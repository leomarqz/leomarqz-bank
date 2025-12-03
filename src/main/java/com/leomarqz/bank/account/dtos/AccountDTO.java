package com.leomarqz.bank.account.dtos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.leomarqz.bank.auth_users.dtos.UserDTO;
import com.leomarqz.bank.enums.AccountStatus;
import com.leomarqz.bank.enums.AccountType;
import com.leomarqz.bank.enums.Currency;
import com.leomarqz.bank.transaction.dtos.TransactionDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class AccountDTO {

    private Long id;
    private String accountNumber;
    private BigDecimal balance;
    private AccountType accountType;

    // this will not be added to the account dto. It will be ignored because it is a back reference.
    @JsonBackReference
    private UserDTO user;

    private Currency currency;
    private AccountStatus accountStatus;

    // If helps avoid recursion loop by ignoring the AccountDTO withing the TransactionDTO
    @JsonManagedReference
    private List<TransactionDTO> transactions;

    private LocalDateTime closedAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
