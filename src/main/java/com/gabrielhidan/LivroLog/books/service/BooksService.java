package com.gabrielhidan.LivroLog.books.service;
import com.gabrielhidan.LivroLog.books.entities.Books;
import com.gabrielhidan.LivroLog.books.repository.BooksRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BooksService {

    @Autowired
    private final BooksRepository booksRepository;

    // getAllBooks

    public List<Books> getAllBooks(){
        return booksRepository.findAll();
    }

    // create new Book

    public Books createNewBook(Books books){
        return booksRepository.save(books);
    }

}
