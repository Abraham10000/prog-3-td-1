package app.prog.repository;

import app.prog.model.AuthorEntity;
import app.prog.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<AuthorEntity, String> {
    @Query(value = "select * from author order by name asc")
    List<AuthorEntity> findAll();

    Optional<AuthorEntity> findByName(String name);
}
