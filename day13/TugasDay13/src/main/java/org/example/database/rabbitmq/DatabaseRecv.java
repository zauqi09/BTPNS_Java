package org.example.database.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

import org.example.database.service.*;

public class DatabaseRecv {

    private ConnectionFactory factory;
    private Connection connection;
    private Channel channel;
    private EntityManager entityManager;
    private MahasiswaDAO mhsDao;
    public void connectJPA(){
        this.entityManager = Persistence
                .createEntityManagerFactory("mahasiswa-unit")
                .createEntityManager();
        mhsDao = new MahasiswaDAO(entityManager);
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
        factory = new ConnectionFactory();
        factory.setHost("localhost");
        connection = factory.newConnection();
    }

    public void addMhs() {
        try {
            connectRabbitMQ();
            channel = connection.createChannel();
            channel.queueDeclare("insertMahasiswa", false, false, false, null);
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String mhsString = new String(delivery.getBody(), StandardCharsets.UTF_8);
                System.out.println(" [x] Received '" + mhsString + "'");
                connectJPA();
                mhsDao.addMhsDAO(mhsString);
                commitJPA();
            };
            channel.basicConsume("insertMahasiswa", true, deliverCallback, consumerTag -> {
            });
        } catch (Exception e) {
            System.out.println("Error insertMahasiswa = " + e);
        }
    }


    public void updateMhs() {
        try {
            connectRabbitMQ();
            channel = connection.createChannel();
            channel.queueDeclare("updateMahasiswaById", false, false, false, null);
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String mhsString = new String(delivery.getBody(), StandardCharsets.UTF_8);
                System.out.println(" [x] Received '" + mhsString + "'");
                connectJPA();
                mhsDao.updateMhsDAO(mhsString);
                commitJPA();
            };
            channel.basicConsume("updateMahasiswaById", true, deliverCallback, consumerTag -> {
            });
        } catch (Exception e) {
            System.out.println("Error updateMahasiswaById = " + e);
        }
    }

    public void absensiMhs() {
        try {
            connectRabbitMQ();

            channel = connection.createChannel();
            channel.queueDeclare("TambahAbsenMhs", false, false, false, null);
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String idString = new String(delivery.getBody(), StandardCharsets.UTF_8);
                System.out.println(" [x] Received '" + idString + "'");
                connectJPA();
                mhsDao.absensiDAO(idString);
                commitJPA();
            };
            channel.basicConsume("TambahAbsenMhs", true, deliverCallback, consumerTag -> {
            });
        } catch (Exception e) {
            System.out.println("Error TambahAbsenMhs = " + e);
        }
    }
}
