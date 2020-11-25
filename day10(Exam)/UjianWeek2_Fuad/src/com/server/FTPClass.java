package com.server;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class FTPClass {
    String server;
    int port;
    String user;
    String pass;
    FTPClient ftpClient = new FTPClient();
    String filename;
    FTPFile[] listdir;
    public FTPClass(String filename){
        this.filename=filename;
    }

    public FTPClass(){

    }
    public FTPClient getFtp(){
        return ftpClient;
    }
    public void listDir() throws IOException {
        listdir = ftpClient.listDirectories();
        DateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (FTPFile file : listdir) {
            String details = file.getName();
            if (file.isDirectory()) {
                details = "[" + details + "]";
            }
            details += "\t\t" + file.getSize();
            details += "\t\t" + dateFormater.format(file.getTimestamp().getTime());
            System.out.println(details);
        }
    }
    public void listDir(String dir) throws IOException {
        listdir = ftpClient.listFiles("/"+dir);
        DateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (FTPFile file : listdir) {
            String details = file.getName();
            if (file.isDirectory()) {
                details = "[" + details + "]";
            }
            details += "\t\t" + file.getSize();
            details += "\t\t" + dateFormater.format(file.getTimestamp().getTime());
            System.out.println(details);
        }
    }
    public void propLoad(String file){
        Properties prop = new Properties();
        InputStream input = null;
        try {

            input = new FileInputStream(file);
            prop.load(input);
            server = prop.getProperty("hostFTP");
            port = Integer.parseInt(prop.getProperty("portFTP"));
            user = prop.getProperty("userFTP");
            pass = prop.getProperty("paswdFTP");

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
    public void Start() throws IOException {
        propLoad("./src/com/client/config.properties");
        ftpClient.connect(server, port);
        ftpClient.login(user, pass);
        ftpClient.enterLocalPassiveMode();
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
    }

    public void Upload(String filename) throws IOException {
        File firstLocalFile = new File("C:\\Users\\btpnshifted\\Desktop\\"+filename);

        String firstRemoteFile = "result_fuad.csv";
        InputStream inputStream = new FileInputStream(firstLocalFile);

        boolean done = ftpClient.storeFile(firstRemoteFile, inputStream);
        inputStream.close();
        if (done) {
            System.out.println("The file is uploaded successfully.");
        }
    }

    public void Download(String filename) throws IOException {
        // APPROACH #1: using retrieveFile(String, OutputStream)
        String remoteFile1 = "/MahasiswaGet/"+filename;
        File downloadFile1 = new File("C:\\Users\\btpnshifted\\Desktop\\"+filename);
        OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
        boolean success = ftpClient.retrieveFile(remoteFile1, outputStream1);
        outputStream1.close();

        if (success) {
            System.out.println("File has been downloaded successfully.");
        }
    }
}
