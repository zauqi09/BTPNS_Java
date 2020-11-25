package com.server;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Siswa{
    String fullname,name,address,status;
    int physics,calculus,biologi;
    public Siswa(String fullname, String address, String status, int physics, int calculus, int biologi){
        this.fullname = fullname;
        this.address = address;
        this.status = status;
        this.physics = physics;
        this.calculus = calculus;
        this.biologi = biologi;
    }

    public Siswa(){

    }

    public void showData(Conn jdbc){
        try{
            Statement stmt=jdbc.getConn().createStatement();
            ResultSet rs=stmt.executeQuery(String.format("select * from siswa"));
            while(rs.next()){
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getInt(5)+"  "+rs.getInt(6)+"  "+rs.getInt(7));
            }
        }catch(Exception e){ System.out.println(e);}
    }

    public void resultData(Conn jdbc) throws IOException {
        try{
            FileWriter writer = new FileWriter("C:\\Users\\btpnshifted\\Desktop\\result_fuad.csv");
            BufferedWriter buffer = new BufferedWriter(writer);
            Statement stmt=jdbc.getConn().createStatement();
            ResultSet rs=stmt.executeQuery(String.format("select * from siswa"));
            while(rs.next()){
                buffer.write(rs.getInt(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4)+","+rs.getInt(5)+","+rs.getInt(6)+","+rs.getInt(7));
                buffer.write("\n");
            }
            buffer.close();
            writer.close();
        }catch(Exception e){ System.out.println(e);}

    }

    public void editData(Conn jdbc,int id,String fullname, String address, String status, int physics, int calculus, int biologi){
        try{
            Statement stmt=jdbc.getConn().createStatement();
            int result=stmt.executeUpdate("update siswa set fullname='"+fullname+"',address='"+address+"',status='"+status+"',physics="+physics+",calculus="+calculus+",biologi="+biologi+" where id="+id);
            if(result!=0){
                System.out.println(result+" records affected");
            } else {
                System.out.println("data not valid");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void inputData(Conn jdbc){
        try{
            Statement stmt=jdbc.getConn().createStatement();
            int result=stmt.executeUpdate("insert into siswa values(null,'"+fullname+"','"+address+"','"+status+"',"+physics+","+calculus+","+biologi+")");
            if(result!=0){
                System.out.println(result+" records affected");
            } else {
                System.out.println("id not valid or data not valid");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void deleteData(Conn jdbc, int id){
        try{
            Statement stmt=jdbc.getConn().createStatement();
            int result=stmt.executeUpdate("delete from siswa where id="+id);
            if(result!=0){
                System.out.println(result+" records affected");
            } else {
                System.out.println("id not valid");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
