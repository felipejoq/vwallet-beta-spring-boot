package com.uncodigo.vwallet.repositories;

import com.uncodigo.vwallet.models.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IBankAccountRepository extends JpaRepository<BankAccount, Integer>{
    Optional<BankAccount> findByOwnerEmail(String email);
}
