package com.genai.StoreProcJava.entity.bank;

import javax.persistence.*;

@Entity
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private String branch_name;

    @Column
    private String branch_city;

    @Column
    private String asset_city;
}
