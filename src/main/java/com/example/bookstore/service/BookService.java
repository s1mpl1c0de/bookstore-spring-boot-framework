package com.example.bookstore.service;

import com.example.bookstore.dto.request.BookRequest;
import com.example.bookstore.dto.response.BookResponse;
import com.example.bookstore.model.Book;
import com.example.bookstore.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public void createBook(BookRequest bookRequest) {
        Book book = new Book()
           .setTitle(bookRequest.getTitle())
           .setAuthor(bookRequest.getAuthor())
           .setPublishedDate(bookRequest.getPublishedDate());

        bookRepository.createBook(book);
    }

    public List<BookResponse> getBooksByAuthor(String author) {
        return bookRepository.getBooksByAuthor(author)
           .stream()
           .map(book -> new BookResponse()
              .setId(book.getId())
              .setTitle(book.getTitle())
              .setAuthor(book.getAuthor())
              .setPublishedDate(book.getPublishedDate())
           ).toList();
    }
}
