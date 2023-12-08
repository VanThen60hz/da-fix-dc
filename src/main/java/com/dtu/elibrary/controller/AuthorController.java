package com.dtu.elibrary.controller;

import com.dtu.elibrary.payload.AuthorDto;
import com.dtu.elibrary.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/author")
public class AuthorController {
    AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping()
    public ResponseEntity<List<AuthorDto>> getAllAuthor(){
        return ResponseEntity.of(Optional.ofNullable(authorService.getAllAuthor()));
    }
}
