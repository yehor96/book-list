package com.yehor.booklist.repository;

import com.yehor.booklist.entity.Book;
import com.yehor.booklist.entity.BookStatus;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Book.builder()
                .id(rs.getLong("id"))
                .title(rs.getString("title"))
                .authorId(rs.getLong("author_id"))
                .status(BookStatus.valueOf(rs.getString("status").toUpperCase()))
                .build();
    }
}
