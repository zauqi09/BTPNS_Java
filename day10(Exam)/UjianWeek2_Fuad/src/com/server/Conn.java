package com.server;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Conn {
    public Connection con;
    String user;
    String password;
    String url;
    public void start(){
        propLoad("./src/com/client/config.properties");
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url,user,password);
//here sonoo is database name, root is username and password
        }catch(Exception e){ System.out.println(e);}
    }
    public void propLoad(String file){
        Properties prop = new Properties();
        InputStream input = null;
        try {

            input = new FileInputStream(file);
            prop.load(input);
            user = prop.getProperty("userDB");
            url = prop.getProperty("url");
            password = prop.getProperty("paswdDB");

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public Connection getConn(){
        return this.con;
    }
}
