package org.example.restapi.rabbitmq;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class RestApiSend {

    public static void getUser(String idString) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare("getdataUser", false, false, false, null);
            channel.basicPublish("", "getdataUser", null, idString.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + idString + "'");
        }
    }

    //login
    public static void login(String userString) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare("loginUser", false, false, false, null);
            channel.basicPublish("", "loginUser", null, userString.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + userString + "'");
        }
    }

    //logout
    public static void logout() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            String logoutString = "Request Logout";
            channel.queueDeclare("logoutUser", false, false, false, null);
            channel.basicPublish("", "logoutUser", null, logoutString.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + logoutString + "'");
        }
    }

    //register
    public static void register(String userString) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare("registerUser", false, false, false, null);
            channel.basicPublish("", "registerUser", null, userString.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + userString + "'");
        }
    }

}

