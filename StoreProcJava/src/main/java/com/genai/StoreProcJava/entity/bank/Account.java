package com.genai.StoreProcJava.entity.bank;

import javax.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column
    private String customer_id;

    @Column
    private String branch_name;

    @Column
    private float balance;
}
