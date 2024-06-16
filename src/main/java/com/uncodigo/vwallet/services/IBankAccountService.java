package com.uncodigo.vwallet.services;

import com.uncodigo.vwallet.models.BankAccount;
import com.uncodigo.vwallet.models.Transactions;

import java.math.BigDecimal;
import java.util.Optional;

public interface IBankAccountService {
    Optional<BankAccount> findBankAccountByUserEmail(String userEmail);
    void addAmountToBalance(Transactions transaction);
    void subtractAmountFromBalance(Transactions transaction);
}
