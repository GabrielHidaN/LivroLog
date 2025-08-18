package com.gabrielhidan.LivroLog.books.service;
import com.gabrielhidan.LivroLog.books.entities.Books;
import com.gabrielhidan.LivroLog.books.repository.BooksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BooksService {

    private final BooksRepository booksRepository;

    public List<Books> getAllBooks(){
        return booksRepository.findAll();
    }

    public Books createNewBook(Books books){
        return booksRepository.save(books);
    }

    public Books getBookById(Long id){
        Optional<Books> getBooksById = booksRepository.findById(id);
        if (getBooksById.isPresent()){
            return getBooksById.orElse(null);
        }
        return null;
    }

    public void deleteBook(Long id){
        Optional<Books> getBook = booksRepository.findById(id);
        if (getBook.isPresent()){
            booksRepository.deleteById(id);
        }else{
            return;
        }
    }


    public Books updateBook(Long id , Books bookUpdate){
        Optional<Books> getBook = booksRepository.findById(id);
        if (getBook.isPresent()){
            bookUpdate.setId(id);
            return booksRepository.save(bookUpdate);
        }
        return null;
    }
}
