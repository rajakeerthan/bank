package com.banking.bankapplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="Transaction")
public class Transaction {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name="type")
    private String type;

    @Column(name="amount")
    private double amount;

    @Column(name="accId")
    private Long accId;

}
