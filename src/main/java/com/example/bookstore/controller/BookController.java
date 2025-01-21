package com.example.bookstore.controller;

import com.example.bookstore.dto.request.BookRequest;
import com.example.bookstore.dto.response.BookResponse;
import com.example.bookstore.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    @PostMapping
    public ResponseEntity<Void> createBook(@Valid @RequestBody BookRequest bookRequest) {
        bookService.createBook(bookRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BookResponse>> getBooksByAuthor(@RequestParam String author) {
        List<BookResponse> bookResponses = bookService.getBooksByAuthor(author);
        return new ResponseEntity<>(bookResponses, HttpStatus.OK);
    }
}
