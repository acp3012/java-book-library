package in.yesh.bookservice.dtos;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookResponse {
    @ApiModelProperty(value = "The unique id that identify the book.")
    private String bookId;
    @ApiModelProperty(value = "The name of the book.")
    private String bookName;
    @ApiModelProperty(value = "The name of the author who wrote the book.")
    private String author;
    @ApiModelProperty(value = "Available copies of the book for subscription.")
    private int availableCopies;
    @ApiModelProperty(value = "Total copies of the book as per library record.")
    private int totalCopies;
}
