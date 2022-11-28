package in.yesh.bookservice.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssueResponse {
    @ApiModelProperty(value = "Subscription status, if the book issued successfully or not.")
    private boolean issueStatus;
    @ApiModelProperty(value = "The name of the subscriber.")
    private String subscriberName;
    @ApiModelProperty(value = "The id of the book issued.")
    private String bookId;
    @ApiModelProperty(value = "The issue date of the book.")
    private LocalDate dateIssued;
}
