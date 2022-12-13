package app.prog.service;

import app.prog.model.BookEntity;
import app.prog.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.StringTokenizer;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository repository;

    public List<BookEntity> getBooks() {
        return repository.findAll();
    }

    public List<BookEntity> createBooks(List<BookEntity> toCreate) {
        return repository.saveAll(toCreate);
    }

    public BookEntity findById(int id){
        Optional<BookEntity> optional = repository.findById(String.valueOf(id));
        if (optional.isPresent()) {
            return optional.get();
        } else{
           throw new NullPointerException("User not found");
        }
    }

    public List<BookEntity> updateBooks(List<BookEntity> toUpdate) {
        return repository.saveAll(toUpdate);
    }

    //TODO-3: should I use Integer here or int ? Why ?
    public ResponseEntity<String> deleteBook(int BookEntityId) {
        Optional<BookEntity> optional = repository.findById(String.valueOf(BookEntityId));
        if (optional.isPresent()) {
            repository.delete(optional.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else{
            return new ResponseEntity<>("BookEntity"+ BookEntityId + "not found", HttpStatus.NOT_FOUND);
        }
    }
}
