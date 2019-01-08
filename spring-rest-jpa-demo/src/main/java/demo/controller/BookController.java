package demo.controller;

import demo.entity.Book;
import demo.mapper.BookMapper;
import demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookMapper mapper;

    @PostMapping
    @PreAuthorize("hasRole('BOOK_MANAGER')")
    public Book create(@RequestBody Book request) {
        return bookService.save(request);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('BOOK_MANAGER')")
    public Book update(@PathVariable Long id, @RequestBody Book request) {
        Book entity = bookService.get(id);
        mapper.map(request, entity);
        bookService.save(entity);
        return entity;
    }

    @SuppressWarnings("unchecked")
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('BOOK_MANAGER')")
    public ResponseEntity<Book> delete(@PathVariable Long id) {
        Book entity = bookService.delete(id);
        if (entity == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(entity);
        }
    }

    @BookManagerOrUser
    @GetMapping("/{id}")
    public Book get(@PathVariable Long id) {
        return bookService.get(id);
    }

    @GetMapping
    @PostFilter("filterObject.releaseDate.after(new Date())")
    public List<Book> getAll() {
        return bookService.getAll();
    }

    @GetMapping("/ids")
    @PreFilter(value = "bookFilterService.filter(filterObject)", filterTarget = "ids")
    public List<Book> getAll(List<String> ids) {
        return bookService.getAll();
    }


    @BookManagerOrUser
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

    @Service
    public class BookFilterService {

        public boolean filter(String id) {
            return id.startsWith("1500") || id.startsWith("1600");
        }
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @PreAuthorize("hasAnyRole('BOOK_MANAGER', 'USER', 'USER2', 'USER3')")
    public @interface BookManagerOrUser {
    }
}
