package in.yesh.bookservice.controller;

import in.yesh.bookservice.dtos.BookRequest;
import in.yesh.bookservice.dtos.BookResponse;
import in.yesh.bookservice.dtos.IssueRequest;
import in.yesh.bookservice.dtos.IssueResponse;
import in.yesh.bookservice.services.BookServiceable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private  final BookServiceable bookServiceable;

    public BookController(BookServiceable bookServiceable) {
        this.bookServiceable = bookServiceable;
    }

    @GetMapping("{bookId}")
    public ResponseEntity<BookResponse> getBookById(@PathVariable String bookId){
        return new ResponseEntity<>(bookServiceable.getBookById(bookId), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<BookResponse>> getBookById(){
        return new ResponseEntity<>(bookServiceable.getAllBooks(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<String> createBook(@RequestBody BookRequest bookRequest){
        return new ResponseEntity<>(bookServiceable.createBook(bookRequest),HttpStatus.CREATED);
    }
    // http://localhost:8081/api/{bookid}/issue
    @PostMapping("{bookId}/issues")
    public ResponseEntity<IssueResponse> issueBook(@PathVariable String bookId,
                                                   @RequestBody IssueRequest issueRequest){
        boolean issued = bookServiceable.issueBook(bookId);
        IssueResponse response = new IssueResponse(issued, issueRequest.getSubscriberName(), bookId, LocalDate.now());
        HttpStatus responseStatus = issued? HttpStatus.CREATED: HttpStatus.UNPROCESSABLE_ENTITY;
        return new ResponseEntity<>(response, responseStatus);

    }
}
