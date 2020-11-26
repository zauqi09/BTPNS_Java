package org.example.database.rabbitmq;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.example.database.model.User;
import org.example.database.service.*;

public class DatabaseRecv {
    private final DatabaseSend send = new DatabaseSend();
    private Connection connection;
    private Channel channel;
    private EntityManager entityManager;
    private UserDAO mhsDao;
    private final List<Session> session = new ArrayList<>();
    public void connectJPA(){
        this.entityManager = Persistence
                .createEntityManagerFactory("user-unit")
                .createEntityManager();
        mhsDao = new UserDAO(entityManager);
        try {
            entityManager.getTransaction().begin();
        } catch (IllegalStateException e) {
            entityManager.getTransaction().rollback();
        }
    }
    //    private Adapter adapter = new Adapter();
    public void commitJPA(){
        try {
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (IllegalStateException e) {
            entityManager.getTransaction().rollback();
        }
    }

    public void connectRabbitMQ() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        connection = factory.newConnection();
    }

    public void getUser() {
        try {
            connectRabbitMQ();
            channel = connection.createChannel();
            channel.queueDeclare("getdataUser", false, false, false, null);
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String userString = new String(delivery.getBody(), StandardCharsets.UTF_8);
                System.out.println(" [x] Received '" + userString + "'");
                connectJPA();
                User user= mhsDao.findId(userString);
                boolean statusLogin = false;
                for (Session obj: session){
                    if (user!=null){
                        if (obj.getAccount_number().equals(user.getAccount_number())) {
                            statusLogin = true;
                            break;
                        }
                    }
                }

                if (statusLogin) {
                    String usrString = new Gson().toJson(user);
                    if(mhsDao.isRegistered(usrString)){
                        send.sendUser(usrString);
                    } else {
                        send.sendUser("User not found!");
                    }
                } else {
                    send.sendUser("Login is required, please Login first!");
                }
                commitJPA();
            };
            channel.basicConsume("getdataUser", true, deliverCallback, consumerTag -> {
            });
        } catch (Exception e) {
            System.out.println("Error getdataUser = " + e);
        }
    }

    public void login() {
        try {
            connectRabbitMQ();
            channel = connection.createChannel();
            channel.queueDeclare("loginUser", false, false, false, null);
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String userString = new String(delivery.getBody(), StandardCharsets.UTF_8);
                System.out.println(" [x] Received '" + userString + "'");
                connectJPA();
                User userFound = new Gson().fromJson(userString, User.class);
                boolean statusLogin = false;
                for (Session obj: session){
                    if (obj.getAccount_number().equals(userFound.getAccount_number())) {
                        statusLogin = true;
                        break;
                    }
                }

                if (statusLogin) {
                    send.sendLogin("User with account number " + userFound.getAccount_number() + " has already login");
                } else {
                    mhsDao.checkAccNumPin(userString);
                    session.add(new Session(userFound.getAccount_number()));
                    send.sendLogin("Login with success!");
                }
                commitJPA();

            };
            channel.basicConsume("loginUser", true, deliverCallback, consumerTag -> {
            });
        } catch (Exception e) {
            System.out.println("Error login = " + e);
        }
    }

    public void logout() {
        try {
            connectRabbitMQ();
            channel = connection.createChannel();
            channel.queueDeclare("logoutUser", false, false, false, null);
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String userString = new String(delivery.getBody(), StandardCharsets.UTF_8);
                System.out.println(" [x] Received '" + userString + "'");
                connectJPA();
                if (!session.isEmpty()) {
                    session.clear();
                    send.sendLogout("Logout success!");
                } else {
                    send.sendLogout("Logout fail! no session detected");
                }
                commitJPA();
            };
            channel.basicConsume("logoutUser", true, deliverCallback, consumerTag -> {
            });
        } catch (Exception e) {
            System.out.println("Error logoutUser = " + e);
        }
    }


    public void register() {
        try {
            connectRabbitMQ();
            channel = connection.createChannel();
            channel.queueDeclare("registerUser", false, false, false, null);
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String userString = new String(delivery.getBody(), StandardCharsets.UTF_8);
                System.out.println(" [x] Received '" + userString + "'");
                connectJPA();
                User userFound = new Gson().fromJson(userString, User.class);
                userFound.setBalance(1250000L);
                if(mhsDao.isRegistered(userString)){
                    send.sendRegister("User with account number " + userFound.getAccount_number()  + " has registered");
                } else {
                    mhsDao.addUserDAO(userString);
                    send.sendRegister(new Gson().toJson(userFound));
                }
                commitJPA();
            };
            channel.basicConsume("registerUser", true, deliverCallback, consumerTag -> {
            });
        } catch (Exception e) {
            System.out.println("Error registerUser = " + e);
        }
    }


}
