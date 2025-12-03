
package com.leomarqz.bank.transaction.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.leomarqz.bank.enums.TransactionType;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionRequest {

    private TransactionType transactionType;
    private String accountNumber;
    private BigDecimal amount;
    private String description;

    private String destinationAccountNumber;
}
