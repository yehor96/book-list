package com.yehor.booklist.repository;

import com.yehor.booklist.entity.Author;
import com.yehor.booklist.repository.mapper.AuthorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AuthorsRepository {

    private static final AuthorMapper AUTHOR_MAPPER = new AuthorMapper();

    private static final String FIND_ALL_SQL = "SELECT id, full_name FROM authors;";
    private static final String ADD_SQL = "INSERT INTO authors (full_name) VALUES (?);";
    private static final String DELETE_SQL = "DELETE FROM authors WHERE id = ?;";
    private static final String UPDATE_SQL = "UPDATE authors SET full_name = ? WHERE id = ?;";

    private final JdbcTemplate jdbcTemplate;

    public List<Author> findAll() {
        return jdbcTemplate.query(FIND_ALL_SQL, AUTHOR_MAPPER);
    }

    public void add(Author author) {
        jdbcTemplate.update(ADD_SQL, author.getFullName());
    }

    public void delete(long id) {
        jdbcTemplate.update(DELETE_SQL, id);
    }

    public void update(long id, Author author) {
        jdbcTemplate.update(UPDATE_SQL, author.getFullName(), id);
    }

}
