package com.gabrielhidan.LivroLog.books.service;
import com.gabrielhidan.LivroLog.books.dto.BooksDTO;
import com.gabrielhidan.LivroLog.books.entities.Books;
import com.gabrielhidan.LivroLog.books.mapper.BooksMapper;
import com.gabrielhidan.LivroLog.books.repository.BooksRepository;
import com.gabrielhidan.LivroLog.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BooksService {

    private final BooksRepository booksRepository;
    private final CategoryRepository categoryRepository;
    private final BooksMapper booksMapper;



    public List<BooksDTO> getAllBooks(){
        List<Books> booksList= booksRepository.findAll();
        return booksList.stream()
                .map(booksMapper::toDTO)
                .collect(Collectors.toList());

    }

    public BooksDTO createNewBook(BooksDTO booksDTO){

        Books books = booksMapper.toEntity(booksDTO);
        books = booksRepository.save(books);
        return  booksMapper.toDTO(books);
    }

    public BooksDTO getBookById(Long id){
        Optional<Books> getBooksById = booksRepository.findById(id);

        if(getBooksById.isPresent()){
            return getBooksById.map(booksMapper::toDTO).orElse(null);
        }
        return null;
    }

    public void deleteBook(Long id){
        Optional<Books> getBook = booksRepository.findById(id);
        if (getBook.isPresent()){
            booksRepository.deleteById(id);
        }
    }


    public BooksDTO updateBook(Long id , BooksDTO booksDTO){
        Optional<Books> bookExist = booksRepository.findById(id);
        if (bookExist.isPresent()){
            Books booksUpdate = booksMapper.toEntity(booksDTO);
            booksUpdate.setId(id);
            Books bookSave = booksRepository.save(booksUpdate);
            return booksMapper.toDTO(bookSave);

        }
        return null;
    }
}
