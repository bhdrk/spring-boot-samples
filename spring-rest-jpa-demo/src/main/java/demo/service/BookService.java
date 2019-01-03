package demo.service;

import demo.entity.Book;
import demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book save(Book book) {
        bookRepository.save(book);
        return book;
    }

    public Book get(Long id) {
        return bookRepository.getOne(id);
    }

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public Page<Book> getAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    public Book delete(Long id) {
        Optional<Book> entity = bookRepository.findById(id);
        if (entity.isPresent()) {
            bookRepository.delete(entity.get());
            return entity.get();
        } else {
            return null;
        }
    }
}
