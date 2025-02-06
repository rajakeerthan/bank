package com.banking.bankapplication.service;

import com.banking.bankapplication.dto.TransactionDto;
import com.banking.bankapplication.mapper.AccountMapper;
import com.banking.bankapplication.mapper.TransactionMapper;

import com.banking.bankapplication.dto.AccountDto;
import com.banking.bankapplication.model.Account;
import com.banking.bankapplication.model.Transaction;
import com.banking.bankapplication.repository.AccountRepo;
import com.banking.bankapplication.repository.TransRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {


    @Autowired
    private AccountRepo accountRepo;
    public AccountService(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    @Autowired
    private TransRepo transRepo;
    public void TransactionService(TransRepo transRepo) {
        this.transRepo = transRepo;
    }

    public AccountDto createAccount(AccountDto accountDto){

        Account account=AccountMapper.mapToAccount(accountDto);
        Account savedAccount=accountRepo.save(account);

        return AccountMapper.mapToAccountDto(savedAccount);
    }

    public AccountDto getAccountById(Long id){
        Account account= accountRepo
                .findById(id)
                .orElseThrow(()->new RuntimeException("Account does not exist"));
        return AccountMapper.mapToAccountDto(account);
    }

    public AccountDto deposit(Long id,double money){
        Account account= accountRepo
                .findById(id)
                .orElseThrow(()->new RuntimeException("Account does not exist"));
        double total=account.getBalance()+money;
        account.setBalance(total);
        Account savedAccount=accountRepo.save(account);

        Transaction trans=new Transaction();
        trans.setType("Deposit");
        trans.setAmount(money);
        trans.setAccId(account.getAccNum());

        transRepo.save(trans);
        return AccountMapper.mapToAccountDto(savedAccount);

    }

    public AccountDto withDraw(Long id,double money){
        Account account=accountRepo
                .findById(id)
                .orElseThrow(()->new RuntimeException("Account not found"));
        double total=account.getBalance()-money;
        if(total<0){
            throw new RuntimeException("Insuffiecent Balance");
        }
        else{
            Transaction trans=new Transaction();
            trans.setType("WithDraw");
            trans.setAmount(money);
            trans.setAccId(account.getAccNum());

            transRepo.save(trans);
        }
        account.setBalance(total);
        Account updatedAccount=accountRepo.save(account);
        return AccountMapper.mapToAccountDto(updatedAccount);

    }

    public List<AccountDto> getAllAccounts(){
        List<Account> accounts=accountRepo.findAll();
        return accounts.stream().map((account)->AccountMapper.mapToAccountDto(account))
                .collect(Collectors.toList());
    }

    public void deleteAccount(Long id){
        Account account=accountRepo
                .findById(id)
                .orElseThrow(()->new RuntimeException("Accountant does not exists"));
        accountRepo.deleteById(id);

    }

    public List<TransactionDto> getTransactions(long accNum) {
        List<Transaction> transactions=transRepo.findByAccId(accNum);
        return transactions.stream().map((transaction)->TransactionMapper.mapToTransactionDto(transaction))
                .collect(Collectors.toList());
    }
}
