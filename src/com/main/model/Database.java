package com.main.model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class Database{
    public static Database db;

    private static String url;
    private static String username;
    private static String password;

    private Database(String url, String username, String password){
        db.url = url;
        db.username = username;
        db.password = password;
    }

    public static Database setInstance(String url, String username, String password){
        if (db == null)
            return new Database(url, username, password);
        else
            return db;
    }

    public static Connection establishConnection(){
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");
            Connection con = DriverManager.getConnection(url, username, password);
            return con;
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }
}