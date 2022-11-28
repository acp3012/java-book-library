package in.yesh.bookservice.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(description = "Provide book information to store in library.")
public class BookRequest {
    @ApiModelProperty(value = "The unique id that identify the book.",
            example = "B1002",
            notes = "The book id must be unique and duplication not allowed.",
            required = true,
            position = 1
    )
    @NotBlank(message = "Book id cannot be blank")
    @Size(max=10)
    private String bookId;

    @ApiModelProperty(value = "The name of the book.",
            example = "Ponniyin selvan part-1.",
            required = true,
            position = 2
    )

    private String bookName;

    @ApiModelProperty(value = "The author name the book.",
            example = "Kalki",
            required = true,
            position = 3
    )
    private String author;

    @ApiModelProperty(value = "Number of copies of the book.",
            example = "5",
            required = true,
            position = 4
    )
    private int totalCopies;
}