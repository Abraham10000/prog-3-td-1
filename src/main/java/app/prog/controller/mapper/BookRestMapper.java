package app.prog.controller.mapper;

import app.prog.controller.response.BookResponse;
import app.prog.controller.response.CreateBookResponse;
import app.prog.controller.response.UpdateBookResponse;
import app.prog.model.AuthorEntity;
import app.prog.model.BookEntity;
import app.prog.service.AuthorService;
import app.prog.service.BookService;
import org.springframework.stereotype.Component;

@Component
public class BookRestMapper {
    private BookService service;
    private AuthorService authorService;
    public BookResponse toRest(BookEntity domain) {
        return BookResponse.builder()
                .id(domain.getId())
                .title(domain.getTitle())
                .author(domain.getAuthor() != null ? domain.getAuthor().getName() : null)
                .hasAuthor(domain.hasAuthor())
                .build();
    }

    public BookEntity toDomain(CreateBookResponse rest) {
        AuthorEntity associateAuthor = authorService.findByNameAuth(rest.getAuthor());
        return BookEntity.builder()
                .id(associateAuthor != null ? associateAuthor.getId() : null)
                .author(associateAuthor)
                .title(rest.getTitle())
                .pageNumber(0) //Constraint not null in database, default value is 0
                .build();
    }

    public BookEntity toUpdate(UpdateBookResponse rest) {
        AuthorEntity associateAuthor = authorService.findByNameAuth(rest.getAuthor());

        BookEntity toUpdate = service.findById(rest.getId());
        toUpdate.setAuthor(associateAuthor);
        toUpdate.setTitle(rest.getTitle());
        return toUpdate;
    }
}
