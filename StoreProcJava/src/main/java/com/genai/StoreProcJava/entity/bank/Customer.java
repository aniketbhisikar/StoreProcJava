package com.genai.StoreProcJava.entity.bank;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private String customer_name;

    @Column
    private String customer_street;

    @Column
    private String customer_city;
}
