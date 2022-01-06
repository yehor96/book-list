package com.yehor.booklist.controller;

import com.yehor.booklist.entity.Author;
import com.yehor.booklist.service.AuthorsService;
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
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorsController {

    private final AuthorsService authorsService;

    @GetMapping
    public List<Author> findAll() {
        return authorsService.findAll();
    }

    @PostMapping
    public void add(@RequestBody Author author) {
        authorsService.add(author);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        authorsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") long id, @RequestBody Author author) {
        authorsService.update(id, author);
    }

}
