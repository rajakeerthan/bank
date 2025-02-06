package com.banking.bankapplication.repository;

import com.banking.bankapplication.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransRepo extends JpaRepository<Transaction,Long> {

    List<Transaction> findByAccId(long accNum);
}
