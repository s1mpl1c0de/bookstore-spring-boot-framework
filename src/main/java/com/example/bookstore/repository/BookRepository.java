package com.example.bookstore.repository;

import com.example.bookstore.model.Book;
import com.example.bookstore.rowmapper.BookRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void createBook(Book book) {
        String sql = "INSERT INTO books (title, author, published_date) VALUES (:title, :author, :published_date)";

        SqlParameterSource paramSource = new MapSqlParameterSource()
           .addValue("title", book.getTitle())
           .addValue("author", book.getAuthor())
           .addValue("published_date", book.getPublishedDate());

        namedParameterJdbcTemplate.update(sql, paramSource);
    }

    public List<Book> getBooksByAuthor(String author) {
        String sql = "SELECT id, title, author, published_date FROM books WHERE LOWER(author) LIKE LOWER(:author)";
        SqlParameterSource parameterSource = new MapSqlParameterSource("author", "%" + author + "%");
        return namedParameterJdbcTemplate.query(sql, parameterSource, new BookRowMapper());
    }
}
