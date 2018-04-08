package com.main.helper;

import com.main.model.Database;

import java.sql.Connection;

public class DatabaseHelper {
    public static Database db = Database.db;

    public static Database setDatabase(){
        return db.setInstance(
                "jdbc:mysql://localhost:3306/stockexchange?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                "root",
                "");
    }
    public static Connection establishConnection(){
        return db.establishConnection();
    }

}
