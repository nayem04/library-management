package com.librarymanagement.controller;

import com.librarymanagement.exception.BookNotFoundException;
import com.librarymanagement.exception.DuplicateBookException;
import com.librarymanagement.model.Book;
import com.librarymanagement.service.LibraryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final LibraryService libraryService;

    public BookController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @PostMapping
    public ResponseEntity<Book> create(@RequestParam(value = "id") Integer id,
                                       @RequestParam(value = "title") String title,
                                       @RequestParam(value = "author") String author,
                                       @RequestParam(value = "publication_year") Integer publicationYear,
                                       @RequestParam(value = "genre") String genre) throws DuplicateBookException {
        return ResponseEntity.ok(libraryService.addBook(id, title, author, publicationYear, genre));
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestParam(value = "id", required = false) Integer id,
                                         @RequestParam(value = "title", required = false) String title) throws BookNotFoundException {
        libraryService.removeBook(id, title);
        return ResponseEntity.ok("Book deleted successfully.");
    }

    @GetMapping("/search")
    public ResponseEntity<Object> search(@RequestParam(value = "title", required = false) String title,
                                         @RequestParam(value = "author", required = false) String author,
                                         @RequestParam(value = "publication_year", required = false) Integer publicationYear) {
        try {
            return ResponseEntity.ok(libraryService.searchBooks(title, author, publicationYear));
        } catch (BookNotFoundException bookNotFoundException) {
            return ResponseEntity.badRequest().body(bookNotFoundException.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAll() {
        return ResponseEntity.ok(libraryService.getBooks());
    }
}
