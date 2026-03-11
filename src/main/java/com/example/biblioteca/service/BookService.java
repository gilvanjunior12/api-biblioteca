package com.example.biblioteca.service;

import com.example.biblioteca.model.Book;
import com.example.biblioteca.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public Book getBookById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Book not found with id " + id));
    }

    public Book createBook(Book book) {
        return repository.save(book);
    }

    public Book updateBook(Long id, Book updatedBook) {
        Book existingBook = getBookById(id); // pega ou lança erro se não existir
        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setYear(updatedBook.getYear());
        return repository.save(existingBook);
    }

    public void deleteBook(Long id) {
        repository.deleteById(id);
    }
}