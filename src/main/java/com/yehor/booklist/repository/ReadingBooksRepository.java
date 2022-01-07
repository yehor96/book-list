package com.yehor.booklist.repository;

import com.yehor.booklist.entity.ReadingBook;
import com.yehor.booklist.repository.mapper.ReadingBookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReadingBooksRepository {

    private static final ReadingBookMapper READING_BOOK_MAPPER = new ReadingBookMapper();

    private static final String FIND_ALL_SQL = "SELECT book_id, start_date, end_date FROM reading_books;";
    private static final String ADD_SQL = "INSERT INTO reading_books (book_id, start_date, end_date) VALUES (?, ?, ?);";
    private static final String DELETE_SQL = "DELETE FROM reading_books WHERE book_id = ?;";
    private static final String UPDATE_SQL = "UPDATE reading_books SET start_date = ?, end_date = ? WHERE book_id = ?;";

    private final JdbcTemplate jdbcTemplate;

    public List<ReadingBook> findAll() {
        return jdbcTemplate.query(FIND_ALL_SQL, READING_BOOK_MAPPER);
    }

    public void add(ReadingBook readingBook) {
        jdbcTemplate.update(ADD_SQL,
                readingBook.getBookId(),
                readingBook.getStartDate(),
                readingBook.getEndDate());
    }

    public void delete(long id) {
        jdbcTemplate.update(DELETE_SQL, id);
    }

    public void update(long id, ReadingBook readingBook) {
        jdbcTemplate.update(UPDATE_SQL,
                readingBook.getStartDate(),
                readingBook.getEndDate(),
                id);
    }
}
