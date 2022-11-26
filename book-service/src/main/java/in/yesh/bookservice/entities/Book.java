package in.yesh.bookservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book")
public class Book {
    @Id
    @Column(name = "book_id", length = 10)
    private String bookId;
    @Column(name = "book_name", length = 50)
    private String bookName;
    @Column(name = "author", length = 30)
    private String author;
    @Column(name = "available_copies")
    private int availableCopies;
    @Column(name = "total_copies")
    private int totalCopies;
}
