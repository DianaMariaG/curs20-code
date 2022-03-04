package ro.fasttrackit.curs20.homework.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.curs20.homework.entity.Transaction;
import ro.fasttrackit.curs20.homework.entity.Type;
import ro.fasttrackit.curs20.homework.repository.TransactionRepo;
import ro.fasttrackit.curs20.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    private final TransactionRepo repository; //repository e clasa care se ocupa de entitatea Person

    public TransactionService(TransactionRepo repository) {
        this.repository = repository;
    }

    public List<Transaction> getTransactions(Double minAmount, Double maxAmount, Type type) {
        List<Transaction> result = new ArrayList<>();
        if (minAmount == null && maxAmount == null && type == null) {
            result = repository.findAll();
        } else if (minAmount == null && maxAmount == null && type != null) {
            result = repository.findByType(type);
        } else if (minAmount != null && maxAmount == null && type == null) {
            result = repository.findByAmountGreaterThan(minAmount);
        } else if (minAmount == null && maxAmount != null && type == null) {
            result = repository.findByAmountLessThan(maxAmount);
        } else if (minAmount != null && maxAmount == null && type != null) {
            result = repository.findByTypeAndAmountGreaterThan(type, minAmount);
        } else if (minAmount == null && maxAmount != null && type != null) {
            result = repository.findByTypeAndAmountLessThan(type, maxAmount);
        } else if (minAmount != null && maxAmount != null && type == null) {
            result = repository.findByAmountBetween(maxAmount, minAmount);
        }

        return result = repository.findByTypeAndAmountBetween(type, maxAmount, minAmount);
    }

    public Transaction addTransaction(Transaction transaction) {
        return repository.save(transaction);
    }

    public Optional<Transaction> replace(Double id, Transaction transaction) {
        return repository.findById(id)
                .map(existing -> replaceExistingTransaction(existing, transaction));
    }

    public Transaction replaceExistingTransaction(Transaction existing, Transaction replacedTransaction) {
            repository.delete(existing);
            Transaction newTransaction = cloneWithId(replacedTransaction);
            repository.save(cloneWithId(newTransaction));
            return newTransaction;
    }

    private Transaction cloneWithId(Transaction transaction) {
        return new Transaction(
                transaction.getProduct(),
                transaction.getType(),
                transaction.getAmount()
        );
    }

    public Transaction findById (Double id, Transaction transaction) {
        Transaction foundTransaction = null;
        if (transaction.getId() == id) {
            foundTransaction = transaction;
        }
        return foundTransaction;
    }

    public Optional<Transaction> deleteTransactionById(Double id) {
        Optional<Transaction> transactionToDelete = repository.findById(id);
        transactionToDelete.ifPresent(o -> repository.delete(o));
        return transactionToDelete;
    }
}

