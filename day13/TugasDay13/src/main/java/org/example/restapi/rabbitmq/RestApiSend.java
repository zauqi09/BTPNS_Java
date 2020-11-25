package org.example.restapi.rabbitmq;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class RestApiSend {

    public static void addMhs(String mhsString) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare("insertMahasiswa", false, false, false, null);
            channel.basicPublish("", "insertMahasiswa", null, mhsString.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + mhsString + "'");
        }
    }


    public static void updateMhs(String mhsString) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare("updateMahasiswaById", false, false, false, null);
            channel.basicPublish("", "updateMahasiswaById", null, mhsString.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + mhsString + "'");
        }
    }

    public static void absensiMhs(String mhsString) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare("TambahAbsenMhs", false, false, false, null);
            channel.basicPublish("", "TambahAbsenMhs", null, mhsString.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + mhsString + "'");
        }
    }
}

