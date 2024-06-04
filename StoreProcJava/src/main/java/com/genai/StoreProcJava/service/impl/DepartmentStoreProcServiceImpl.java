package com.genai.StoreProcJava.service.impl;

import com.genai.StoreProcJava.config.SqlConnector;
import com.genai.StoreProcJava.entity.institue.Department;
import com.genai.StoreProcJava.service.DepartmentStoreProcService;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentStoreProcServiceImpl implements DepartmentStoreProcService {
    @Override
    public void readDepartmentStoreProc() throws Exception {
        SqlConnector sc = new SqlConnector();
        Connection con = sc.sqlInstituteConnection();

        CallableStatement cs = con.prepareCall("{CALL get_instructors_by_department(?)}");

        cs.setString(1, "Biology");

        ResultSet rs = cs.executeQuery();
        con.close();
    }

    @Override
    public void readDepartmentBudgetStoreProc() throws Exception {
        SqlConnector sc = new SqlConnector();
        Connection con = sc.sqlInstituteConnection();

        CallableStatement cs = con.prepareCall("{CALL set_budget(?)}");

        cs.setInt(1, 2000);
        cs.registerOutParameter(1, Types.INTEGER);

        ResultSet rs = cs.executeQuery();
        int resultado = cs.getInt("budget");
        System.out.println("resultado: "+resultado);
        readDepartmentTable();
        con.close();
    }

    @Override
    public void readDepartmentTable() throws Exception {
        SqlConnector sc = new SqlConnector();
        String sql_string = "select * from department;";

        Connection con = sc.sqlInstituteConnection();
        CallableStatement cs = con.prepareCall(sql_string);

        PreparedStatement ps = con.prepareStatement(sql_string);

        ResultSet rs = ps.executeQuery();
        List<Department> departments = new ArrayList<>();
        while (rs.next())
        {
            departments.add(new Department(rs.getString("dept_name"),rs.getString("building"),rs.getInt("budget")));

        }
        for (Department dept: departments)
        {
            System.out.println("dept_name: "+dept.getDept_name()+", building: "+ dept.getBuilding() + ", budget: "+dept.getBudget());
        }
    }
}
