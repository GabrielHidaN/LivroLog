package com.gabrielhidan.LivroLog.books.controller;
import com.gabrielhidan.LivroLog.books.dto.BooksDTO;
import com.gabrielhidan.LivroLog.books.service.BooksService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BooksController {


    private final BooksService booksService;

    @PostMapping("/create")
    public BooksDTO createNewBook(@RequestBody BooksDTO booksDTO){
        return  booksService.createNewBook(booksDTO);
    }

    @GetMapping("/")
    public List<BooksDTO> getAllBooks(){
        return booksService.getAllBooks();
    }

    @GetMapping("/{id}")
    public  BooksDTO getBookById(@PathVariable Long id){
        return booksService.getBookById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        booksService.deleteBook(id);
    }

    @PutMapping("/{id}")
    public BooksDTO updateBook(@PathVariable Long id ,@RequestBody BooksDTO bookUpdate){
        return booksService.updateBook(id, bookUpdate);
    }
}
