package com.domin.dao;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.*;

/**
 * Created by asouqi on 3/26/18.
 */
public abstract class TemplateDAO<T,I> implements CRUDOperations<T,I> {

    private static BasicDataSource basicDataSource;
    private Connection connection;
    private Statement statement;
    protected ResultSet set;
    protected PreparedStatement preparedStatement;

    public static void setConnection(String url,String userName,String passWord){
        basicDataSource=new BasicDataSource();
        
        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(userName);
        basicDataSource.setPassword(passWord);
        basicDataSource.setMaxActive(10);
    }

    protected void connectWithResultSet(String query){
        try {
            this.connection = basicDataSource.getConnection();
            this.statement = connection.createStatement();
            this.set = statement.executeQuery(query);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void connectWithPreparedStatement(String query) throws SQLException {
        try {
            this.connection = basicDataSource.getConnection();
            this.preparedStatement = connection.prepareStatement(query);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void closeConnection(){
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
