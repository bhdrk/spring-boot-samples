package demo.controller;

import demo.entity.Book;
import demo.mapper.BookMapper;
import demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookMapper mapper;

    @PostMapping
    public Book create(@RequestBody Book request) {
        return bookService.save(request);
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable Long id, @RequestBody Book request) {
        Book entity = bookService.get(id);
        mapper.map(request, entity);
        bookService.save(entity);
        return entity;
    }

    @SuppressWarnings("unchecked")
    @DeleteMapping("/{id}")
    public ResponseEntity<Book> delete(@PathVariable Long id) {
        Book entity = bookService.delete(id);
        if (entity == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(entity);
        }
    }

    @GetMapping("/{id}")
    public Book get(@PathVariable Long id) {
        return bookService.get(id);
    }

    @GetMapping
    public List<Book> getAll() {
        return bookService.getAll();
    }

    @GetMapping("/list")
    public Page<Book> getAll(@RequestParam("p") Integer page,
                             @RequestParam("s") Integer size,
                             @RequestParam("sort") String sortStr) {
        Sort.Order order;
        if (sortStr.charAt(0) == '-') {
            order = Sort.Order.desc(sortStr.substring(1));
        } else {
            order = Sort.Order.asc(sortStr);
        }
        Sort sort = Sort.by(order);
        return bookService.getAll(PageRequest.of(page, size, sort));
    }
}
