package com.gabrielhidan.LivroLog.books.mapper;
import com.gabrielhidan.LivroLog.books.dto.BooksDTO;
import com.gabrielhidan.LivroLog.books.entities.Books;
import org.springframework.stereotype.Component;

@Component
public class BooksMapper {
    public Books map(BooksDTO booksDTO){
        Books books = new Books();

        books.setId(booksDTO.getId());
        books.setTitle(booksDTO.getTitle());
        books.setAuthor(booksDTO.getAuthor());
        books.setDescription(booksDTO.getDescription());
        books.setLanguage(booksDTO.getLanguage());
        books.setCategory(booksDTO.getCategory());

        return books;
    }

    public BooksDTO map(Books books){
        BooksDTO booksDTO = new BooksDTO();

        booksDTO.setId(books.getId());
        booksDTO.setTitle(books.getTitle());
        booksDTO.setAuthor(books.getAuthor());
        booksDTO.setDescription(books.getDescription());
        booksDTO.setLanguage(books.getLanguage());
        booksDTO.setCategory(books.getCategory());

        return booksDTO;
    }
}
