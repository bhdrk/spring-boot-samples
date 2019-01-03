package demo.controller;

import demo.entity.Book;
import demo.mapper.BookMapper;
import demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public Book get(@PathVariable Long id) {
        return bookService.get(id);
    }
}
