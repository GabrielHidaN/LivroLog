package com.gabrielhidan.LivroLog.books.controller;

import com.gabrielhidan.LivroLog.books.entities.Books;
import com.gabrielhidan.LivroLog.books.service.BooksService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
@Getter
@Setter
@AllArgsConstructor
public class BooksController {


    @Autowired
    private final BooksService booksService;

    @PostMapping("/create")
    public Books createNewBook(@RequestBody Books books){
        return  booksService.createNewBook(books);
    }
}
