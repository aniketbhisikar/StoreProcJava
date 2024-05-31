package com.genai.StoreProcJava.service;

import com.genai.StoreProcJava.config.SqlConnector;
import com.genai.StoreProcJava.entity.institue.Department;
import jdk.internal.org.objectweb.asm.Type;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DepartmentStroProcServiceImpl {
    public void readDepartmentStoreProc() throws Exception {
        SqlConnector sc = new SqlConnector();
        Connection con = sc.sqlInstituteConnection();

        CallableStatement cs = con.prepareCall("{CALL get_instructors_by_department(?)}");

        cs.setString(1, "Biology");

        ResultSet rs = cs.executeQuery();
        con.close();
    }

    public void readDepartmentBudgetStoreProc() throws Exception {
        SqlConnector sc = new SqlConnector();
        Connection con = sc.sqlInstituteConnection();

        CallableStatement cs = con.prepareCall("{CALL set_budget(?)}");

        cs.setInt(1, 2000);
        cs.registerOutParameter(1, Type.INT);

        ResultSet rs = cs.executeQuery();
        int resultado = cs.getInt("budget");
        System.out.println("resultado: "+resultado);
        readDepartmentTable();
        con.close();
    }

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
