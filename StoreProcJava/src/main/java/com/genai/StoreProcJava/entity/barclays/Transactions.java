package com.genai.StoreProcJava.entity.barclays;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Getter
@Setter
public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long transaction_id;

    @Column
    private String account_number;

    @Column
    private String customer_id;

    @Column
    private String transaction_memo;
}
