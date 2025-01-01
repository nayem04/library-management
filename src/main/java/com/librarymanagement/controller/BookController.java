package com.librarymanagement.controller;

import com.librarymanagement.exception.DuplicateBookException;
import com.librarymanagement.service.LibraryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final LibraryService libraryService;

    public BookController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestParam(value = "id") Integer id,
                                         @RequestParam(value = "title") String title,
                                         @RequestParam(value = "author") String author,
                                         @RequestParam(value = "publication_year") Integer publicationYear,
                                         @RequestParam(value = "genre") String genre) {
        try {
            libraryService.addBook(id, title, author, publicationYear, genre);
            return ResponseEntity.ok("Book added successfully.");
        } catch (DuplicateBookException duplicateBookException) {
            return ResponseEntity.badRequest().body(duplicateBookException.getMessage());
        }
    }
}
