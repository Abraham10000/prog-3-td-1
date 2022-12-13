package app.prog.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "author")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Date birthDate;
    private String particularity;
    @OneToMany
    @JoinColumn(name = "id")
    private Set<BookEntity> books;

    public boolean hasParticularity(){
        return particularity != null;
    }
}
