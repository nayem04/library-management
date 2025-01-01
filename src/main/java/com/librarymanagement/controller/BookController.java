package com.librarymanagement.controller;

import com.librarymanagement.service.LibraryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final LibraryService libraryService;

    public BookController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }
}
