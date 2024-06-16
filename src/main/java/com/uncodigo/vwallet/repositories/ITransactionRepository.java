package com.uncodigo.vwallet.repositories;

import com.uncodigo.vwallet.models.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ITransactionRepository extends JpaRepository<Transactions, Long> {
    @Query("SELECT t FROM Transactions t WHERE t.sender.id = :accountId OR t.receiver.id = :accountId ORDER BY t.transactionDate DESC")
    Collection<Transactions> findTransactionsByAccountId(@Param("accountId") Integer accountId);
}
