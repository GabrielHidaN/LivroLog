package com.gabrielhidan.LivroLog.books.controller;

import com.gabrielhidan.LivroLog.books.entities.Books;
import com.gabrielhidan.LivroLog.books.service.BooksService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BooksController {


    private final BooksService booksService;

    @PostMapping("/create")
    public Books createNewBook(@RequestBody Books books){
        return  booksService.createNewBook(books);
    }

    @GetMapping("/")
    public List<Books> getAllBooks(){
        return booksService.getAllBooks();
    }

    @GetMapping("/{id}")
    public  Books getBookById(@PathVariable Long id){
        return booksService.getBookById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        booksService.deleteBook(id);
    }

    @PutMapping("/update/{id}")
    public Books updateBook(@PathVariable Long id ,@RequestBody Books bookUpdate){
        return booksService.updateBook(id, bookUpdate);
    }
}
