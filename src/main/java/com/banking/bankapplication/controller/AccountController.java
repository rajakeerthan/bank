package com.banking.bankapplication.controller;

import com.banking.bankapplication.dto.AccountDto;
import com.banking.bankapplication.dto.TransactionDto;
import com.banking.bankapplication.repository.AccountRepo;
import com.banking.bankapplication.repository.TransRepo;
import com.banking.bankapplication.service.AccountService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private TransRepo trnasRepo;

    @GetMapping("transactions/{accNum}")
    public ResponseEntity<List<TransactionDto>> getTransactions(@PathVariable Long accNum){
        List<TransactionDto> transactionDtos=accountService.getTransactions(accNum);
        return ResponseEntity.ok(transactionDtos);
    }



    @PostMapping("/add")
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
        AccountDto accountDto=accountService.getAccountById(id);

        return ResponseEntity.ok(accountDto);
    }

    @PutMapping("/deposit/{id}")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id,@RequestBody Map<String,Double> creditRequest){
        // we cannot take direct money as input because it does not have any inbuilt object like dto's and table
        double money=creditRequest.get("money");
        AccountDto accountDto=accountService.deposit(id,money);

        return ResponseEntity.ok(accountDto);
    }

    @PutMapping("/with-draw/{id}")
    public ResponseEntity<AccountDto> withDraw(@PathVariable Long id,@RequestBody Map<String,Double> requestMoney){
        double money=requestMoney.get("money");
        AccountDto accountDto=accountService.withDraw(id,money);
        return ResponseEntity.ok(accountDto);
    }


    @GetMapping("/get-all-accounts")
    public ResponseEntity<List<AccountDto>> getAllAccounts(){
        List<AccountDto> accountDtos=accountService.getAllAccounts();
        return ResponseEntity.ok(accountDtos);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.ok("successfully deleted");
    }
}

