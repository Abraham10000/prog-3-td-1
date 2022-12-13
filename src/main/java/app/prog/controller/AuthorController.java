package app.prog.controller;
import app.prog.controller.mapper.AuthorRestMapper;
import app.prog.controller.response.*;
import app.prog.model.AuthorEntity;
import app.prog.model.BookEntity;
import app.prog.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class AuthorController {
    private final AuthorService service;
    private final AuthorRestMapper mapper;

    @GetMapping("/authors")
    public List<AuthorResponse> getAuthor() {
        return service.getAuthor().stream()
                .map(mapper::toRest)
                .toList();
    }

    @PostMapping("/authors")
    public List<AuthorResponse> createBooks(@RequestBody List<CreateAuthorResponse> toCreate) {
        List<AuthorEntity> domain = toCreate.stream()
                .map(mapper::toDomain)
                .toList();
        return service.createAuthor(domain).stream()
                .map(mapper::toRest)
                .toList();
    }

    @PutMapping("/authors")
    public List<AuthorResponse> updateBooks(@RequestBody List<UpdateAuthorResponse> toUpdate) {
        List<AuthorEntity> domain = toUpdate.stream()
                .map(mapper::toUpdate)
                .toList();
        return service.updateAuthor(domain).stream()
                .map(mapper::toRest)
                .toList();
    }

    @DeleteMapping("/authors/{authorId}")
    public ResponseEntity<String> deleteAuthor(@PathVariable Integer authorId) {
        return service.deleteAuthor(authorId);
    }
}
