package com.librarymanagement.factory;

import com.librarymanagement.model.Book;

public class BookFactory {
    public Book createBook(Integer id, String title, String author, Integer publicationYear, String genre) {
        return new Book(id, title, author, publicationYear, genre);
    }
}
