package com.genai.StoreProcJava.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class SqlConnector {
    public Connection sqlBankConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Getting the connection
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank?autoReconnect=true&useSSL=false",
                "root","root");
        return con;
    }

    public Connection sqlInstituteConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Getting the connection
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/institute?autoReconnect=true&useSSL=false",
                "root","root");
        return con;
    }

    public Connection sqlBankTransactionConnection(String sqlDriver, String driverUrl, String userName, String userPwd) throws Exception {
        Class.forName(sqlDriver);
        // Getting the connection
        Connection con = DriverManager.getConnection(driverUrl,
                userName,userPwd);
        return con;
    }

    public Connection sqlBarclaysConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Getting the connection
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/barclays?autoReconnect=true&useSSL=false",
                "root","root");
        return con;
    }
}
