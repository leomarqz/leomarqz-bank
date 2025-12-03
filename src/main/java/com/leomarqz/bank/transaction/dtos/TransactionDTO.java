
package com.leomarqz.bank.transaction.dtos;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.leomarqz.bank.account.dtos.AccountDTO;
import com.leomarqz.bank.enums.TransactionStatus;
import com.leomarqz.bank.enums.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionDTO {

    private Long id;
    private BigDecimal amount;
    private TransactionType transactionType;
    private LocalDateTime transactionDate;
    private String description;
    private TransactionStatus transactionStatus;

    @JsonManagedReference
    private AccountDTO account;

    private String sourceAccount;
    private String destinationAccount;

}
