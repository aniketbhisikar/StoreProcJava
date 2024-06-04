package com.genai.StoreProcJava.entity.barclays;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private String account_number;

    @Column
    private String customer_id;

    @Column
    private String account_branch;

    @Column
    private String account_type;

    @Column
    private float account_balance;

    public BankAccount(String account_number, String customer_id, String account_branch, String account_type, float account_balance) {
        this.account_number = account_number;
        this.customer_id = customer_id;
        this.account_branch = account_branch;
        this.account_type = account_type;
        this.account_balance = account_balance;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getAccount_branch() {
        return account_branch;
    }

    public void setAccount_branch(String account_branch) {
        this.account_branch = account_branch;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public float getAccount_balance() {
        return account_balance;
    }

    public void setAccount_balance(float account_balance) {
        this.account_balance = account_balance;
    }
}
