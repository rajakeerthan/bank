package com.banking.bankapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TransactionDto {

    private Long id;
    private String type;
    private double amount;
    private Long accId;
}
