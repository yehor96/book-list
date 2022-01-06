package com.yehor.booklist.service;

import com.yehor.booklist.entity.Book;
import com.yehor.booklist.repository.BooksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BooksService {

    private final BooksRepository booksRepository;

    public List<Book> findAll() {
        return booksRepository.findAll();
    }

    public void add(Book book) {
        booksRepository.add(book);
    }

    public void delete(long id) {
        booksRepository.delete(id);
    }

    public void update(long id, Book book) {
        booksRepository.update(id, book);
    }
}
