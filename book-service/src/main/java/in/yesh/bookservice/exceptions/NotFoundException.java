package in.yesh.bookservice.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)

public class NotFoundException extends RuntimeException {
    private static final String DEFAULT_ERROR_MESSAGE = "Resource does not exists.";
    private static final int DEFAULT_ERROR_CODE = 404;
    private final ErrorDetail errorDetail;
    public NotFoundException(){
        this(null);
    }
    public NotFoundException(@Nullable String field){
        this(DEFAULT_ERROR_MESSAGE, field);
    }
    public NotFoundException(String message, @Nullable String field){
        this(DEFAULT_ERROR_CODE, message, field);
    }
    public NotFoundException(int code, String message, @Nullable String field){
        super(message);
         errorDetail = new ErrorDetail(code, message, field);
    }
    public ErrorDetail getErrorDetail(){
        return this.errorDetail;
    }
}
