package com.yehor.booklist.controller;

import com.yehor.booklist.entity.ReadingBook;
import com.yehor.booklist.service.ReadingBooksService;
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
@RequestMapping("/reading")
@RequiredArgsConstructor
public class ReadingBooksController {

    private final ReadingBooksService readingBooksService;

    @GetMapping
    public List<ReadingBook> findAll() {
        return readingBooksService.findAll();
    }

    @PostMapping
    public void add(@RequestBody ReadingBook readingBook) {
        readingBooksService.add(readingBook);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        readingBooksService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") long id, @RequestBody ReadingBook readingBook) {
        readingBooksService.update(id, readingBook);
    }

}
