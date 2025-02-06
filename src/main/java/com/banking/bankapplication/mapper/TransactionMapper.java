package com.banking.bankapplication.mapper;

import com.banking.bankapplication.dto.AccountDto;
import com.banking.bankapplication.dto.TransactionDto;
import com.banking.bankapplication.model.Account;
import com.banking.bankapplication.model.Transaction;

public class TransactionMapper {
        public static Transaction mapToTransaction(TransactionDto transactionDto){
            Transaction transaction=new Transaction(
                    transactionDto.getId(),
                    transactionDto.getType(),
                    transactionDto.getAmount(),
                    transactionDto.getAccId()
            );
            return transaction;

        }

        public static TransactionDto mapToTransactionDto(Transaction transaction) {
            TransactionDto transactionDto = new TransactionDto(
                    transaction.getId(),
                    transaction.getType(),
                    transaction.getAmount(),
                    transaction.getAccId()
            );
            return transactionDto;
        }


}
