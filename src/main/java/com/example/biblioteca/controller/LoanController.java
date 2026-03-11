package com.example.biblioteca.controller;

import com.example.biblioteca.model.Loan;
import com.example.biblioteca.service.LoanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {

    private final LoanService service;

    public LoanController(LoanService service) {
        this.service = service;
    }

    @GetMapping
    public List<Loan> getAllLoans() {
        return service.getAllLoans();
    }

    @GetMapping("/{id}")
    public Loan getLoanById(@PathVariable Long id) {
        return service.getLoanById(id);
    }

    @PostMapping
    public Loan createLoan(@RequestParam Long userId, @RequestParam Long bookId) {
        return service.createLoan(userId, bookId);
    }

    @PostMapping("/return/{id}")
    public Loan returnLoan(@PathVariable Long id) {
        return service.returnLoan(id);
    }

    @DeleteMapping("/{id}")
    public void deleteLoan(@PathVariable Long id) {
        service.deleteLoan(id);
    }
}