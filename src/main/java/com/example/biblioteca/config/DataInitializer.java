package com.example.biblioteca.config;

import com.example.biblioteca.model.Book;
import com.example.biblioteca.model.User;
import com.example.biblioteca.repository.BookRepository;
import com.example.biblioteca.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(BookRepository bookRepository, UserRepository userRepository) {
        return args -> {

            // Criar livros
            bookRepository.save(new Book(null, "Clean Code", "Robert Martin", 2008));
            bookRepository.save(new Book(null, "Effective Java", "Joshua Bloch", 2018));
            bookRepository.save(new Book(null, "Spring in Action", "Craig Walls", 2020));

            // Criar usuários
            userRepository.save(new User(null, "Alice", "alice@example.com"));
            userRepository.save(new User(null, "Bob", "bob@example.com"));
        };
    }
}
