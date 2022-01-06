package com.yehor.booklist.controller;

import com.yehor.booklist.entity.Book;
import com.yehor.booklist.service.BooksService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BooksController {

    private final BooksService booksService;

    @GetMapping
    public List<Book> findAll() {
        return booksService.findAll();
    }

    @PostMapping
    public void add(@RequestBody Book book) {
        booksService.add(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        booksService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") long id, @RequestBody Book book) {
        booksService.update(id, book);
    }

}
