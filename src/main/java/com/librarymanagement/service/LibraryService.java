package com.librarymanagement.service;

import com.librarymanagement.exception.DuplicateBookException;
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

    public void addBook(Integer id, String title, String author, Integer publicationYear, String genre) throws DuplicateBookException {
        if (books.stream().anyMatch(b -> b.getId().equals(id))) {
            throw new DuplicateBookException("Book with id " + id + " already exists");
        }

        books.add(bookFactory.createBook(id, title, author, publicationYear, genre));
    }
}