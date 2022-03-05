package ro.fasttrackit.curs20.homework.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.curs20.homework.entity.Transaction;
import ro.fasttrackit.curs20.homework.entity.Type;
import ro.fasttrackit.curs20.homework.repository.TransactionRepo;
import ro.fasttrackit.curs20.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    private final TransactionRepo repository; //repository e clasa care se ocupa de entitatea

    public TransactionService(TransactionRepo repository) {
        this.repository = repository;
    }

    public List<Transaction> getTransactions(Double minAmount, Double maxAmount, Type type) {
        List<Transaction> result = new ArrayList<>();
        if (minAmount == null && maxAmount == null && type == null) {
            result = repository.findAll();
        } else if (minAmount == null && maxAmount == null) {
            result = repository.findByType(type);
        } else if (minAmount != null && maxAmount == null && type == null) {
            result = repository.findByAmountGreaterThan(minAmount);
        } else if (minAmount == null && type == null) {
            result = repository.findByAmountLessThan(maxAmount);
        } else if (minAmount != null && maxAmount == null) {
            result = repository.findByTypeAndAmountGreaterThan(type, minAmount);
        } else if (minAmount == null) {
            result = repository.findByTypeAndAmountLessThan(type, maxAmount);
        } else if (type == null) {
            result = repository.findByAmountBetween(minAmount, maxAmount);
        } else {
            result = repository.findByTypeAndAmountBetween(type, minAmount, maxAmount);
        }
        return result;
    }

    public Optional<Transaction> findById(int id) {
        return repository.findById(id);
    }

    public Transaction addTransaction(Transaction transaction) {
        return repository.save(transaction);
    }

    public Transaction update(Transaction transaction) {
        return repository.save(transaction);
    }


    public Optional<Transaction> deleteTransactionById(int id) {
        Optional<Transaction> transactionToDelete = repository.findById(id);
        transactionToDelete.ifPresent(o -> repository.delete(o));
        return transactionToDelete;
    }

    public Map<Type, Double> mapTypeToSumOfAmount() {
        Map<Type, Double> result = repository.findAll().stream()
                .collect(Collectors.groupingBy(Transaction::getType, Collectors.summingDouble(Transaction::getAmount)));
        return result;
    }

    public Map<String, Double> mapProductToSumOfAmount() {
        Map<String, Double> result = repository.findAll().stream()
                .collect(Collectors.groupingBy(Transaction::getProduct,Collectors.summingDouble(Transaction::getAmount)));
        return result;
    }
}

