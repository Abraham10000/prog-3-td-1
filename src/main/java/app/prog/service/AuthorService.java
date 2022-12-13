package app.prog.service;
import app.prog.model.AuthorEntity;
import app.prog.model.BookEntity;
import app.prog.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorService {
    private final AuthorRepository repository;
    public List<AuthorEntity> getAuthor() {
        return repository.findAll();
    }

    public List<AuthorEntity> createAuthor(List<AuthorEntity> toCreate) {
        return repository.saveAll(toCreate);
    }

    public List<AuthorEntity> updateAuthor(List<AuthorEntity> toUpdate) {
        return repository.saveAll(toUpdate);
    }

    public AuthorEntity findbyId(int id){
        Optional<AuthorEntity> optional = repository.findById(String.valueOf(id));
        if (optional.isPresent()) {
            return optional.get();
        } else{
            throw new NullPointerException("Author not found");
        }
    }

    public ResponseEntity<String> deleteAuthor(int AuthorEntityId) {
        Optional<AuthorEntity> optional = repository.findById(String.valueOf(AuthorEntityId));
        if (optional.isPresent()) {
            repository.delete(optional.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Author id : "+ AuthorEntityId + "not found", HttpStatus.NOT_FOUND);
        }
    }

    public AuthorEntity findByNameAuth(String name){
        Optional<AuthorEntity> optional = repository.findByName(name);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw  new NullPointerException("Author not found");
        }
    }
}
