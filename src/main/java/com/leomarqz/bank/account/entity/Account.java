package com.leomarqz.bank.account.entity;

import com.leomarqz.bank.auth_users.entity.User;
import com.leomarqz.bank.enums.AccountStatus;
import com.leomarqz.bank.enums.AccountType;
import com.leomarqz.bank.enums.Currency;
import com.leomarqz.bank.transaction.entity.Transaction;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@Table(name = "accounts")
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length =  15)
    private String accountNumber;

    @Column(nullable = false, precision = 19, scale = 2)
    private BigDecimal balance =  BigDecimal.ZERO;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",  nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    private Currency  currency;

    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Transaction> transactions =  new ArrayList<>();

    private LocalDateTime closedAt;

    private LocalDateTime createdAt =  LocalDateTime.now();

    private LocalDateTime updatedAt;

}
