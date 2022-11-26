package in.yesh.bookservice.repositories;

import in.yesh.bookservice.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,String> {
}
