package ro.fasttrackit.curs20.homework.controller;

import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.curs20.homework.ResourceNotFoundException;
import ro.fasttrackit.curs20.homework.entity.Transaction;
import ro.fasttrackit.curs20.homework.entity.Type;
import ro.fasttrackit.curs20.homework.service.TransactionService;
import ro.fasttrackit.curs20.service.PersonService;

import java.util.List;

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

    @PostMapping
    Transaction addTransaction(@RequestBody Transaction transaction) {
        return service.addTransaction(transaction);
    }

    @PutMapping("{id}")
    Transaction putTransaction(@PathVariable Double id, @RequestBody Transaction transaction) {
        return service.replace(id, transaction)
                .orElseThrow(() -> new ResourceNotFoundException("Nothign found"));
    }

    @DeleteMapping("{id}")
    Transaction deleteTransaction(@PathVariable Double id) {
        return service.deleteTransactionById(id)
                .orElse(null);
    }
}
