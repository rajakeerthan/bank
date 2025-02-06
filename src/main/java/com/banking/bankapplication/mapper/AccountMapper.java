package com.banking.bankapplication.mapper;

import com.banking.bankapplication.dto.AccountDto;
import com.banking.bankapplication.model.Account;

public class AccountMapper {
    public static Account mapToAccount(AccountDto accountDto){
        Account account=new Account(
                accountDto.getId(),
                accountDto.getAccName(),
                accountDto.getBalance(),
                accountDto.getAccNum()
        );
        return account;

    }

    public static AccountDto mapToAccountDto(Account account){
        AccountDto accountDto=new AccountDto(
                account.getId(),
                account.getAccName(),
                account.getBalance(),
                account.getAccNum()
        );
        return accountDto ;

    }


}
