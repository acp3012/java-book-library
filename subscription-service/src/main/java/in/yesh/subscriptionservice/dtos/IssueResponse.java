package in.yesh.subscriptionservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IssueResponse {
    private boolean issueStatus;
    private String subscriberName;
    private String bookId;
    private LocalDate dateIssued;
}