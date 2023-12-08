package com.dtu.elibrary.service;

import com.dtu.elibrary.payload.AuthorDto;

import java.util.List;

public interface AuthorService {
    List<AuthorDto> getAllAuthor();
}
