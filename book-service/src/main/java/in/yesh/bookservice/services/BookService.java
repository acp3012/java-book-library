package in.yesh.bookservice.services;

import in.yesh.bookservice.dtos.BookRequest;
import in.yesh.bookservice.dtos.BookResponse;
import in.yesh.bookservice.entities.Book;
import in.yesh.bookservice.exceptions.NotFoundException;
import in.yesh.bookservice.repositories.BookRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Service
public class BookService implements BookServiceable {
    @Autowired
    private  BookRepository bookRepository;

//    public BookService(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }

    @Override
    public BookResponse getBookById(String bookId) {
        Book book =  bookRepository
                .findById(bookId)
                .orElseThrow(()-> new NotFoundException("bookId"));
        return mapToBookResponse(book);
    }


    @Override
    public List<BookResponse> getAllBooks() {
        List<Book> books =  bookRepository.findAll();
         return books.stream().map(this::mapToBookResponse).collect(Collectors.toList());
    }

    @Override
    public String createBook(BookRequest bookRequest) {
        Book book = mapToBook(bookRequest);
        Book newBook = bookRepository.save(book);
        return newBook.getBookId();

    }

    @Override
    public boolean issueBook(String bookId) {
       boolean status = false;
       Book book = bookRepository.findById(bookId).orElseThrow(()-> new NotFoundException("bookId"));
       if(book.getAvailableCopies() > 0){
           book.setAvailableCopies(book.getAvailableCopies() - 1);
           bookRepository.save(book);
           status = true;
       }
       return status;
    }

    private BookResponse mapToBookResponse(Book book) {
        return BookResponse.builder()
                .bookId(book.getBookId())
                .bookName(book.getBookName())
                .author(book.getAuthor())
                .availableCopies(book.getAvailableCopies())
                .totalCopies(book.getTotalCopies())
                .build();

    }
    private Book mapToBook(BookRequest bookRequest) {
        return Book.builder()
                .bookId(bookRequest.getBookId())
                .bookName(bookRequest.getBookName())
                .author(bookRequest.getAuthor())
                .availableCopies(bookRequest.getTotalCopies())
                .totalCopies(bookRequest.getTotalCopies())
                .build();
    }
}