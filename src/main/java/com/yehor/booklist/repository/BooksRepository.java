package com.yehor.booklist.repository;

import com.yehor.booklist.entity.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BooksRepository {

    private static final BookMapper BOOK_MAPPER = new BookMapper();

    private static final String FIND_ALL_SQL = "SELECT id, title, author_id, status FROM books;";
    private static final String ADD_SQL = "INSERT INTO books (title, author_id, status) VALUES (?, ?, ?);";
    private static final String DELETE_SQL = "DELETE FROM books WHERE id = ?;";
    private static final String UPDATE_SQL = "UPDATE books SET title = ?, author_id = ?, status = ? WHERE id = ?;";

    private final JdbcTemplate jdbcTemplate;

    public List<Book> findAll() {
        return jdbcTemplate.query(FIND_ALL_SQL, BOOK_MAPPER);
    }

    public void add(Book book) {
        jdbcTemplate.update(ADD_SQL, book.getTitle(), book.getAuthorId(), book.getStatus().getValue());
    }

    public void delete(long id) {
        jdbcTemplate.update(DELETE_SQL, id);
    }

    public void update(long id, Book book) {
        jdbcTemplate.update(UPDATE_SQL, book.getTitle(), book.getAuthorId(), book.getStatus().getValue(), id);
    }
}
