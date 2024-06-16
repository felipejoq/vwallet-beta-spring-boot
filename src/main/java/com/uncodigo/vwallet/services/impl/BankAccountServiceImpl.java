package com.uncodigo.vwallet.services.impl;

import com.uncodigo.vwallet.models.BankAccount;
import com.uncodigo.vwallet.models.Transactions;
import com.uncodigo.vwallet.repositories.IBankAccountRepository;
import com.uncodigo.vwallet.services.IBankAccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Optional;

@Service
public class BankAccountServiceImpl implements IBankAccountService {

    private final IBankAccountRepository bankAccountRepository;

    public BankAccountServiceImpl(IBankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public Optional<BankAccount> findBankAccountByUserEmail(String userEmail) {
        return bankAccountRepository.findByOwnerEmail(userEmail);
    }

    @Override
    @Transactional
    public void addAmountToBalance(Transactions transaction) {
        BankAccount sender = transaction.getSender();
        if (sender != null) {
            sender.setBalance(sender.getBalance().add(transaction.getTotal()));
            bankAccountRepository.save(sender);
        }
    }

    @Override
    @Transactional
    public void subtractAmountFromBalance(Transactions transaction) {
        BankAccount sender = transaction.getSender();
        if (sender != null) {
            sender.setBalance(sender.getBalance().subtract(transaction.getTotal()));
            bankAccountRepository.save(sender);
        }

        if(transaction.getTransactionType().getId() == 1) {
            BankAccount receiver = transaction.getReceiver();
            if (receiver != null) {
                receiver.setBalance(receiver.getBalance().add(transaction.getTotal()));
                bankAccountRepository.save(receiver);
            }
        }
    }

}
