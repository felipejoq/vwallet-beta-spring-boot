package com.uncodigo.vwallet.repositories;

import com.uncodigo.vwallet.models.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransactionTypeRepository extends JpaRepository<TransactionType, Long> {
}
