package com.librarymanagement.service;

import com.librarymanagement.factory.BookFactory;
import com.librarymanagement.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibraryService {
    private final List<Book> books = new ArrayList<>();
    private final BookFactory bookFactory;

    public LibraryService(BookFactory bookFactory) {
        this.bookFactory = bookFactory;
    }
}