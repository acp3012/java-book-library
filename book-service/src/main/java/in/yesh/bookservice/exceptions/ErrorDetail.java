package in.yesh.bookservice.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class ErrorDetail {
    private final LocalDateTime timestamp = LocalDateTime.now(ZoneId.of("UTC"));
    private int code;
    private String message;
    // Setter
    public LocalDateTime getTimestamp() {     return timestamp;  }

    public void setCode(int code) {  this.code = code;  }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setField(@Nullable String field) {
        this.field = field;
    }

    // Getter
    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Nullable
    public String getField() {
        return field;
    }

    @Nullable
    private String field;
    public ErrorDetail() {

    }
    public ErrorDetail(int code, String message, @Nullable String field){
        this.code = code;
        this.message = message;
        this.field = field;
    }

}
