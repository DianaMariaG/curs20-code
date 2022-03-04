package ro.fasttrackit.curs20.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.curs20.homework.entity.Transaction;
import ro.fasttrackit.curs20.homework.entity.Type;

import java.util.List;

public interface TransactionRepo extends JpaRepository<Transaction, Double> {
    List<Transaction> findByType(Type type);
    List<Transaction> findByAmountGreaterThan(Double minAmount);
    List<Transaction> findByAmountLessThan(Double maxAmount);
    List<Transaction> findByTypeAndAmountGreaterThan(Type type, Double minAmount);
    List<Transaction> findByTypeAndAmountLessThan(Type type, Double maxAmount);
    List<Transaction> findByAmountBetween (Double maxAmount, Double minAmount);
    List<Transaction> findByTypeAndAmountBetween (Type type, Double maxAmount, Double minAmount);
}
