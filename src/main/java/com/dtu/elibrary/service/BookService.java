package com.dtu.elibrary.service;

import com.dtu.elibrary.payload.BookDto;
import com.dtu.elibrary.payload.BookResponse;

import java.util.Optional;

public interface BookService {

    BookResponse getAllBook(int pageNo, int pageSize, String sortBy, String sortDir);
    BookResponse findBookByName(int pageNo, int pageSize, String sortBy, String sortDir, String name);

    BookDto addNewBook(BookDto bookDto);

    BookDto getBookById(int id);
}
