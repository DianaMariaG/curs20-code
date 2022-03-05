package ro.fasttrackit.curs20.homework.controller;

import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.curs20.homework.entity.Transaction;
import ro.fasttrackit.curs20.homework.entity.Type;
import ro.fasttrackit.curs20.homework.service.TransactionService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequestMapping("transactions")
@RestController

public class TransactionController {
    private final TransactionService service;
    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @GetMapping
    List<Transaction> getTransactions (@RequestParam(required = false) Double minAmount,
                                       @RequestParam(required = false) Double maxAmount,
                                       @RequestParam(required = false) Type type) {
        return service.getTransactions(minAmount, maxAmount, type);
    }

    @GetMapping("/{id}")
    Optional<Transaction> findById(@PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping
    Transaction addTransaction(@RequestBody Transaction transaction) {
        return service.addTransaction(transaction);
    }

    @PutMapping
    Transaction putTransaction(@RequestBody Transaction transaction) {
        return service.update(transaction);
    }

    @DeleteMapping("{id}")
    Transaction deleteTransaction(@PathVariable int id) {
        return service.deleteTransactionById(id)
                .orElse(null);
    }


    @GetMapping("/reports/type")
    Map<Type, Double> mapTypeToAmountSum() {
        return service.mapTypeToSumOfAmount();
    }

    @GetMapping("/reports/type")
    Map<String, Double> mapProductToAmountSum() {
        return service.mapProductToSumOfAmount();
    }
}
