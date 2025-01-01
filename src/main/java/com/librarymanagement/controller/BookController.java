package com.librarymanagement.controller;

import com.librarymanagement.exception.BookNotFoundException;
import com.librarymanagement.exception.DuplicateBookException;
import com.librarymanagement.service.LibraryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam(value = "id", required = false) Integer id,
                                         @RequestParam(value = "title", required = false) String title) {
        try {
            libraryService.removeBook(id, title);
            return ResponseEntity.ok("Book deleted successfully.");
        } catch (BookNotFoundException bookNotFoundException) {
            return ResponseEntity.badRequest().body(bookNotFoundException.getMessage());
        }
    }
}
