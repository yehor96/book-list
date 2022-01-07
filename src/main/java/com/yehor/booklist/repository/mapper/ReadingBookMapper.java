package com.yehor.booklist.repository.mapper;

import com.yehor.booklist.entity.ReadingBook;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;

public class ReadingBookMapper implements RowMapper<ReadingBook> {
    @Override
    public ReadingBook mapRow(ResultSet rs, int rowNum) throws SQLException {
        long bookId = rs.getLong("book_id");
        LocalDate startDate = rs.getDate("start_date").toLocalDate();
        LocalDate endDate = Optional.ofNullable(rs.getDate("end_date"))
                .map(Date::toLocalDate)
                .orElse(null);

        return ReadingBook.builder()
                .bookId(bookId)
                .startDate(startDate)
                .endDate(endDate)
                .build();
    }
}
