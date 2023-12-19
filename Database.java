package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    public Connection databaseLink;
    public Connection getConnection(){
        String databaseName="java";
        String databaseUser="root";
        String databasePassword="Varun#45";
        String url="jdbc:mysql://localhost/" + databaseName;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink=DriverManager.getConnection(url,databaseUser,databasePassword);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return databaseLink;
    }
}