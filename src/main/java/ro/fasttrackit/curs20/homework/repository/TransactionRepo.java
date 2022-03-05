package ro.fasttrackit.curs20.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.curs20.homework.entity.Transaction;
import ro.fasttrackit.curs20.homework.entity.Type;

import java.util.List;

public interface TransactionRepo extends JpaRepository<Transaction, Integer> {
    List<Transaction> findByType(Type type);
    List<Transaction> findByAmountGreaterThan(Double minAmount);
    List<Transaction> findByAmountLessThan(Double maxAmount);
    List<Transaction> findByTypeAndAmountGreaterThan(Type type, Double minAmount);
    List<Transaction> findByTypeAndAmountLessThan(Type type, Double maxAmount);
    List<Transaction> findByAmountBetween (Double minAmount, Double maxAmount);
    List<Transaction> findByTypeAndAmountBetween (Type type, Double minAmount, Double maxAmount);
}
