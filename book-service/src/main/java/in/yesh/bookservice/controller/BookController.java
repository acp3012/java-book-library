package in.yesh.bookservice.controller;

import in.yesh.bookservice.dtos.BookRequest;
import in.yesh.bookservice.dtos.BookResponse;
import in.yesh.bookservice.dtos.IssueRequest;
import in.yesh.bookservice.dtos.IssueResponse;
import in.yesh.bookservice.services.BookServiceable;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Api(tags="Book service - provides book stock entry, retrieves book information.")
@RestController
@RequestMapping("/api/books")
public class BookController {

    private  final BookServiceable bookServiceable;

    public BookController(BookServiceable bookServiceable) {
        this.bookServiceable = bookServiceable;
    }

    @ApiOperation("Retrieves book information for a given book id.")
    @GetMapping("{bookId}")
    public ResponseEntity<BookResponse> getBookById(@PathVariable String bookId){
        return new ResponseEntity<>(bookServiceable.getBookById(bookId), HttpStatus.OK);
    }
    @ApiOperation("Retrieves all books available in the library.")
    @GetMapping
    public ResponseEntity<List<BookResponse>> getBookById(){
        return new ResponseEntity<>(bookServiceable.getAllBooks(), HttpStatus.OK);
    }
    @ApiOperation(value = "Create a new entry of a book in the library.", notes = "Making a new entry in library system")
    @PostMapping
    public ResponseEntity<String> createBook(@RequestBody BookRequest bookRequest){
        return new ResponseEntity<>(bookServiceable.createBook(bookRequest),HttpStatus.CREATED);
    }

    // http://localhost:8081/api/{bookId}/issue
    @ApiOperation(value = "Issue a book to a subscriber.",
            notes = "Only one copy of the book will be issued if stock available.If the book id id not found, Not found error response will be sent. ")
    @PostMapping("{bookId}/issues")
    public ResponseEntity<IssueResponse> issueBook(@PathVariable String bookId,
                                                   @RequestBody IssueRequest issueRequest){
        boolean issued = bookServiceable.issueBook(bookId);
        IssueResponse response = new IssueResponse(issued, issueRequest.getSubscriberName(), bookId, LocalDate.now());
        HttpStatus responseStatus = issued? HttpStatus.CREATED: HttpStatus.UNPROCESSABLE_ENTITY;
        return new ResponseEntity<>(response, responseStatus);

    }
}
