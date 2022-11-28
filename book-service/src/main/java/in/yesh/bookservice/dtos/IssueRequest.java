package in.yesh.bookservice.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IssueRequest {
    @ApiModelProperty(value = "The name of the subscriber.",
            allowEmptyValue = false,
            required = true
    )
    @NotBlank
    @Size(min=3, max=30, message = "Subscriber name must be at lease 3 char and should not exceed 30 characters.")
    private String subscriberName;
}
