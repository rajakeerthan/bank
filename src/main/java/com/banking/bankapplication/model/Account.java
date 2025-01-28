package com.banking.bankapplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="account")
public class Account {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="accname")
    private String accName;

    @Column(name="balance")
    private double balance;
}