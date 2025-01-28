package com.banking.bankapplication.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.banking.bankapplication.model.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {
}
