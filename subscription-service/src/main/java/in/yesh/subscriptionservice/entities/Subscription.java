package in.yesh.subscriptionservice.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 50)
    private String name;
    private LocalDate dateSubscribed = LocalDate.now();
    private LocalDate dateReturned;
    private String bookId;
}