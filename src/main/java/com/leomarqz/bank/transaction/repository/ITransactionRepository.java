
package com.leomarqz.bank.transaction.repository;

import com.leomarqz.bank.account.entity.Account;
import com.leomarqz.bank.transaction.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITransactionRepository extends JpaRepository<Transaction, Long> {

    Page<Transaction> findByAccount_AccountNumber(String accountNumber, Pageable pageable);

    List<Transaction> findByAccount_AccountNumber(String accountNumber);

    List<Transaction> findByAccount_AccountNumber(Account account);

}
