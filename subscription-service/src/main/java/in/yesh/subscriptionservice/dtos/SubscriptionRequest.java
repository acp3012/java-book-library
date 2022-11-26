package in.yesh.subscriptionservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class SubscriptionRequest {
    private String name;
    private String bookId;
}
