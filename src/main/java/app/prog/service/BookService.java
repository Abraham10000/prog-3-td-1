package app.prog.service;

import app.prog.model.Book;
import app.prog.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository repository;

    public List<Book> getBooks() {
        return repository.findAll();
    }

    public List<Book> createBooks(List<Book> toCreate) {
        return repository.saveAll(toCreate);
    }

    public List<Book> updateBooks(List<Book> toUpdate) {
        return repository.saveAll(toUpdate);
    }

    public Book deleteBook(int bookId) {
        Optional<Book> optional = repository.findById(bookId);
        if (optional.isPresent()) {
            repository.delete(optional.get());
            return optional.get();
        } else {
            throw new RuntimeException("Book." + bookId + " not found");
        }
    }

    public Book getBookById(int id) {
        return repository.getById(id);
    }
}
