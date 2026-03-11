package com.example.biblioteca.service;

import com.example.biblioteca.model.Book;
import com.example.biblioteca.model.Loan;
import com.example.biblioteca.model.User;
import com.example.biblioteca.repository.BookRepository;
import com.example.biblioteca.repository.LoanRepository;
import com.example.biblioteca.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public LoanService(LoanRepository loanRepository, BookRepository bookRepository, UserRepository userRepository) {
        this.loanRepository = loanRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    public Loan getLoanById(Long id) {
        return loanRepository.findById(id).orElse(null);
    }

    public Loan createLoan(Long userId, Long bookId) {
        Optional<User> userOpt = userRepository.findById(userId);
        Optional<Book> bookOpt = bookRepository.findById(bookId);

        if (userOpt.isPresent() && bookOpt.isPresent()) {
            Loan loan = new Loan();
            loan.setUser(userOpt.get());
            loan.setBook(bookOpt.get());
            loan.setLoanDate(LocalDate.now());
            loan.setReturnDate(null);
            return loanRepository.save(loan);
        }

        return null;
    }

    public Loan returnLoan(Long loanId) {
        Optional<Loan> loanOpt = loanRepository.findById(loanId);

        if (loanOpt.isPresent()) {
            Loan loan = loanOpt.get();
            loan.setReturnDate(LocalDate.now());
            return loanRepository.save(loan);
        }

        return null;
    }

    public void deleteLoan(Long id) {
        loanRepository.deleteById(id);
    }
}