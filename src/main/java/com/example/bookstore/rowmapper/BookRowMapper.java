package com.example.bookstore.rowmapper;

import com.example.bookstore.model.Book;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRowMapper implements RowMapper<Book> {

    @Override
    public Book mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        return new Book()
           .setId(resultSet.getInt("id"))
           .setTitle(resultSet.getString("title"))
           .setAuthor(resultSet.getString("author"))
           .setPublishedDate(resultSet.getDate("published_date").toLocalDate());
    }
}
