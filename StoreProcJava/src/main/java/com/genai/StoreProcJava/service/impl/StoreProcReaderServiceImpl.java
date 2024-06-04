package com.genai.StoreProcJava.service.impl;

import com.genai.StoreProcJava.config.SqlConnector;
import com.genai.StoreProcJava.service.StoreProcReaderService;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class StoreProcReaderServiceImpl implements StoreProcReaderService {

    @Override
    public void readStoreProcedure() throws Exception {
        SqlConnector sc = new SqlConnector();
        String sql_string = "select * from account;";

        Connection con = sc.sqlBankConnection();
        CallableStatement cs = con.prepareCall(sql_string);

        PreparedStatement ps = con.prepareStatement(sql_string);

        ResultSet rs = ps.executeQuery();
        List<String> matchingNames = new ArrayList<>();
        while (rs.next())
        {
            String name = rs.getString("customer_name");
            matchingNames.add(name);
        }
        for (String name: matchingNames)
        {
            System.out.println("customer_name: "+name);
        }
    }
}
