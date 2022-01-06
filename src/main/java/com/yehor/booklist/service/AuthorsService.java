package com.yehor.booklist.service;

import com.yehor.booklist.entity.Author;
import com.yehor.booklist.repository.AuthorsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorsService {

    private final AuthorsRepository authorsRepository;

    public List<Author> findAll() {
        return authorsRepository.findAll();
    }

    public void add(Author author) {
        authorsRepository.add(author);
    }

    public void delete(long id) {
        authorsRepository.delete(id);
    }

    public void update(long id, Author author) {
        authorsRepository.update(id, author);
    }

}
