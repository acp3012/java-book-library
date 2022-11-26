package in.yesh.bookservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookResponse {
    private String bookId;
    private String bookName;
    private String author;
    private int availableCopies;
    private int totalCopies;
}
