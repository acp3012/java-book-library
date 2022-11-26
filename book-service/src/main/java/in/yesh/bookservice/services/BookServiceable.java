package in.yesh.bookservice.services;

import in.yesh.bookservice.dtos.BookRequest;
import in.yesh.bookservice.dtos.BookResponse;

import java.util.List;

public interface BookServiceable {

    BookResponse getBookById(String bookId);
    List<BookResponse> getAllBooks();
    String createBook(BookRequest bookRequest);

    boolean issueBook(String bookId);
}
