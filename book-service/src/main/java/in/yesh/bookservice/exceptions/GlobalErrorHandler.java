package in.yesh.bookservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalErrorHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDetail> notFoundExceptionHandler(NotFoundException ex, WebRequest request){
        return sendResponse(ex);
    }

    private ResponseEntity<ErrorDetail> sendResponse(RuntimeException ex){
        if(ex instanceof NotFoundException){
            return new ResponseEntity<>(((NotFoundException) ex).getErrorDetail(), HttpStatus.NOT_FOUND);
        }
        return null;
    }
}
