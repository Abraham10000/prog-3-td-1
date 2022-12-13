package app.prog.repository;

import app.prog.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, String> {
    @Query(value = "select * from book order by releasedate asc", nativeQuery = true)
    List<BookEntity> findall();
}
