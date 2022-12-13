package app.prog.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "book")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false, insertable = false, updatable = false)
    private AuthorEntity author;
    private Integer pageNumber;
    private LocalDate releaseDate;
    @ManyToMany
    @JoinTable(
            name = "has_category",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_category")
    )
    List<CategoryEntity> Category;


    public boolean hasAuthor() {
        return author != null;
    }

}
