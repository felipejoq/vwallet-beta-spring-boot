package com.uncodigo.vwallet.services;

import com.uncodigo.vwallet.dto.TransactionDto;
import com.uncodigo.vwallet.dto.TransferDto;
import com.uncodigo.vwallet.models.Transactions;

import java.util.Collection;

public interface ITransactionService {
    void deposit(TransactionDto transactionDto);
    void withdraw(TransactionDto transactionDto);
    void transfer(TransferDto transferDto);
    Collection<Transactions> getTransactionsByUserEmail(String userEmail);
}
