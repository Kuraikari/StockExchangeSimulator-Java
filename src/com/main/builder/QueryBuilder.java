package com.main.builder;

import com.main.helper.DatabaseHelper;
import com.main.model.Database;

import java.sql.*;
import java.util.*;

public class QueryBuilder {
    public Database db;
    public String query;
    public ArrayList<String> fields;
    public ArrayList<String> values;
    public Object table;
    public Object[] fieldsArray;
    public Object[] fieldsValuesArray;
    public HashMap<String, String> row;

    public QueryBuilder(){
        this.db = (db != null) ? DatabaseHelper.db : DatabaseHelper.setDatabase();
    }

    public HashMap<String, String> query(Connection con, String query){
        HashMap<String, String> rows = new HashMap<String, String>();
        try (PreparedStatement stmt = con.prepareStatement(this.query)){
            ResultSet res = stmt.executeQuery();
            int i = 1;
            while (res.next()){
                if (i <= res.getMetaData().getColumnCount() - 1)
                    for (int j = 0; j < res.getMetaData().getColumnCount(); j++)
                        rows.put(res.getMetaData().getColumnName(i), res.getString(i++));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    //SELECT BUILD
    public QueryBuilder select(String entity){
        this.query = "Select " + entity  + " ";
        System.out.println(query);
        return this;
    }

    public QueryBuilder from(String table){
        this.query += "from " + "`" + table + "`" + " ";
        System.out.println(query);
        return this;
    }

    public QueryBuilder where(String attribute, String value){
        this.query += "where " + attribute + "=" + "\"" + value + "\"" + " ";
        System.out.println(query);
        return this;
    }

    public QueryBuilder and(String attribute, String value){
        this.query += "and " + attribute + "=" + "\"" + value + "\"" + " ";
        System.out.println(query);
        return this;
    }

    /******************************************************
     * HOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO *
     ******************************************************/

    //INSERT BUILD
    public QueryBuilder insert(Object entity){
        this.fields = new ArrayList<String>();
        this.values = new ArrayList<String>();
        this.table = entity;
        return this;
    }

    public QueryBuilder addField(String attribute){
        this.fields.add(attribute);
        return this;
    }

    public QueryBuilder addValue(String value){
        this.values.add(value);
        return this;
    }

    public QueryBuilder addLastValue(String value){
        this.values.add(value);
        String fieldAsString = String.join(",", this.fields);
        int valueCount = this.values.size();
        return this;
    }

    /********************************************************
     * HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH *
     ********************************************************/

    public Map<String, String> fieldValuesToArray(){
        Map<String, String> fieldValuesArray = new HashMap<String, String>();
        for (String value : fields) {
            for (String value2: values) {
                fieldValuesArray.put(value, value2);
            }
        }
        return fieldValuesArray;
    }

    public QueryBuilder execute(){
       row = this.query(DatabaseHelper.establishConnection(), this.query);
       return this;
    }

    public String returnValueFromRow(String column){
        System.out.println(row.get(column));
        return row.get(column);
    }
}
