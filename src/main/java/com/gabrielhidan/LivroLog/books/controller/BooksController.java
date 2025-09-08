package com.gabrielhidan.LivroLog.books.controller;
import com.gabrielhidan.LivroLog.books.dto.BooksDTO;
import com.gabrielhidan.LivroLog.books.service.BooksService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BooksController {


    private final BooksService booksService;

    @PostMapping("/create")
    public ResponseEntity<String> createNewBook(@RequestBody BooksDTO booksDTO){
        BooksDTO createBook = booksService.createNewBook(booksDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("The Book : " + createBook.getTitle() + " Created with Success!");

    }

    @GetMapping("/")
    public ResponseEntity<List<BooksDTO>> getAllBooks(){
        List<BooksDTO> getAllBooks =  booksService.getAllBooks();
        return ResponseEntity.ok(getAllBooks);
    }

    @GetMapping("/{id}")
    public  ResponseEntity<?> getBookById(@PathVariable Long id){

        BooksDTO booksDTO = booksService.getBookById(id);

        if (booksDTO != null){
            return ResponseEntity.status(HttpStatus.FOUND)
                    .body(booksDTO);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Book not found!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        BooksDTO getBook =  booksService.getBookById(id);
        if (getBook != null){
            BooksDTO deleteBook = booksService.deleteBook(id);
            return ResponseEntity.ok("Book Deleted Success!");
        }
        return  ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Book not found!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBook(@PathVariable Long id ,@RequestBody BooksDTO bookUpdate){
        BooksDTO updateBook = booksService.updateBook(id, bookUpdate);
        if (updateBook != null){
            return ResponseEntity.ok(updateBook);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Book not found!");
    }
}
