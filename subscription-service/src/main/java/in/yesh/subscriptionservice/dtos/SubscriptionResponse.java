package in.yesh.subscriptionservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubscriptionResponse {
    private long id;
    private String name;
    private String bookId;
    private LocalDate dateSubscribed;
    private LocalDate dateReturned;
}
