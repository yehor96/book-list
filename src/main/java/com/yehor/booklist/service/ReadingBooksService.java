package com.yehor.booklist.service;

import com.yehor.booklist.entity.ReadingBook;
import com.yehor.booklist.repository.ReadingBooksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReadingBooksService {

    private final ReadingBooksRepository readingBooksRepository;

    public List<ReadingBook> findAll() {
        return readingBooksRepository.findAll();
    }

    public void add(ReadingBook readingBook) {
        readingBooksRepository.add(readingBook);
    }

    public void delete(long id) {
        readingBooksRepository.delete(id);
    }

    public void update(long id, ReadingBook readingBook) {
        readingBooksRepository.update(id, readingBook);
    }

}
