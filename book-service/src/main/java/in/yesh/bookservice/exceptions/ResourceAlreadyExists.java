package in.yesh.bookservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ResourceAlreadyExists extends RuntimeException{

    private static final String DEFAULT_ERROR_MESSAGE = "Resource already exists.";
    private static final int DEFAULT_ERROR_CODE = 409;
    private final ErrorDetail errorDetail;
    public ResourceAlreadyExists(@Nullable String field){
        errorDetail = new ErrorDetail(DEFAULT_ERROR_CODE,DEFAULT_ERROR_MESSAGE,field);
    }

    public ErrorDetail getErrorDetail(){
        return this.errorDetail;
    }

}
