package com.genai.StoreProcJava.service.impl;

import com.genai.StoreProcJava.config.SqlConnector;
import com.genai.StoreProcJava.entity.barclays.BankAccount;
import com.genai.StoreProcJava.entity.barclays.Customer;
import com.genai.StoreProcJava.service.BankTransactionStoreProcService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Service
public class BankTransactionStoreProcServiceImpl implements BankTransactionStoreProcService {

    @Value("${mysql.jdbc.driverName:com.mysql.cj.jdbc.Driver}")
    String mySqlDriver;

    @Value("${mysql.jdbc.driverUrl:jdbc:mysql://localhost:3306/barclays?autoReconnect=true&useSSL=false}")
    String mySqlDriverUrl;

    @Value("${mysql.jdbc.userName:root}")
    String mySqlUserName;

    @Value("${mysql.jdbc.userpassword:root}")
    String mySqlUserPwd;

    @Override
    public String BankAccountTransactionStoreProc(String acct_id, float tran_amt, String tran_type) throws Exception {
        SqlConnector sc = new SqlConnector();
        Connection con = sc.sqlBankTransactionConnection(mySqlDriver,mySqlDriverUrl,mySqlUserName,mySqlUserPwd);
        //Connection con = sc.sqlBarclaysConnection();
        BankAccount account = readBankAccountTable(acct_id);
        Customer cust = readCustomerTable(account.getCustomer_id());
        String tran_memo = cust.getCustomer_name()+" did "+tran_type+" transaction of Rs."+tran_amt;
        CallableStatement cs = con.prepareCall("{CALL bank_transaction_details(?,?,?,?,?)}");

        cs.setString(1, acct_id);
        cs.setFloat(2, tran_amt);
        cs.setString(3, cust.getCustomer_id());
        cs.setString(4, tran_memo);
        cs.setString(5, tran_type);

        ResultSet rs = cs.executeQuery();
        con.close();
        account = readBankAccountTable(acct_id);
        return tran_memo;
    }

    private BankAccount readBankAccountTable(String acct_id) throws Exception {
        SqlConnector sc = new SqlConnector();
        String sql_string = "select * from bank_account where account_number=?;";

        Connection con = sc.sqlBankTransactionConnection(
                "com.mysql.cj.jdbc.Driver",
                "jdbc:mysql://localhost:3306/barclays?autoReconnect=true&useSSL=false",
                "root","root");

        PreparedStatement ps = con.prepareStatement(sql_string);
        ps.setString(1,acct_id);
        ResultSet rs = ps.executeQuery();
        BankAccount account = new BankAccount("","","","",0);
        while (rs.next())
        {
            account = new BankAccount(rs.getString("account_number"),rs.getString("customer_id"),rs.getString("account_branch"), rs.getString("account_type"),rs.getFloat("account_balance"));
        }
        printAccount(account);
        return account;
    }

    private void printAccount(BankAccount account) {
        System.out.println("cust_id: "+account.getCustomer_id()+", Acct_number: "+ account.getAccount_number() + ", type: "+account.getAccount_type()+", branch: "+account.getAccount_branch()+", balance: "+account.getAccount_balance());
    }

    private void printCustomer(Customer customer) {
        System.out.println("cust_id: "+customer.getCustomer_id()+", name: "+ customer.getCustomer_name() + ", address: "+customer.getCustomer_address());
    }

    private Customer readCustomerTable(String cust_id) throws Exception {
        SqlConnector sc = new SqlConnector();
        String sql_string = "select * from Customer where customer_id=?;";

        Connection con = sc.sqlBankTransactionConnection(
        "com.mysql.cj.jdbc.Driver",
        "jdbc:mysql://localhost:3306/barclays?autoReconnect=true&useSSL=false",
        "root","root");

        PreparedStatement ps = con.prepareStatement(sql_string);
        ps.setString(1,cust_id);
        ResultSet rs = ps.executeQuery();
        Customer customer = new Customer("","","");
        while (rs.next())
        {
            customer = new Customer(rs.getString("customer_id"),rs.getString("customer_name"), rs.getString("customer_name"));
        }
        printCustomer(customer);
        return customer;
    }

}
