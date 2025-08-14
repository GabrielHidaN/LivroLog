package com.gabrielhidan.LivroLog.books.repository;

import com.gabrielhidan.LivroLog.books.entities.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksRepository extends JpaRepository<Books , Long> {
}
