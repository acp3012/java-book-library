package in.yesh.bookservice.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDetail> notFoundExceptionHandler(NotFoundException ex,
                                                                WebRequest request){
        return sendResponse(ex);
    }
    @ExceptionHandler(ResourceAlreadyExists.class)
    public ResponseEntity<ErrorDetail> notFoundExceptionHandler(ResourceAlreadyExists ex,
                                                                WebRequest request){
        return sendResponse(ex);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetail> handleGlobalException(Exception ex){
        return sendResponse(ex);

    }
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
            Map<String, String> errors = new HashMap<>();
            ex.getBindingResult().getAllErrors().forEach((error)->{
               String field =  ((FieldError)error).getField();
               String message = error.getDefaultMessage();
               errors.put("field", field);
               errors.put("message",message);
            });
            return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
        //return handleExceptionInternal(ex, null, headers, status, request);
    }
    // global exception

    private ResponseEntity<ErrorDetail> sendResponse(Exception ex){

        ErrorDetail errorDetail = new ErrorDetail();
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        if(ex instanceof NotFoundException){
            errorDetail = ((NotFoundException) ex).getErrorDetail();
            status = HttpStatus.NOT_FOUND;
        }
        else if(ex instanceof ResourceAlreadyExists){
            errorDetail = ((ResourceAlreadyExists) ex).getErrorDetail();
            status = HttpStatus.CONFLICT;
        }

        else {
             errorDetail = new ErrorDetail(500,"Something went wrong. Please try after sometime or contact support team.",null);
        }
        return new ResponseEntity<>(errorDetail,status);
    }
}
