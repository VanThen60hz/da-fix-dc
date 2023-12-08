package com.dtu.elibrary.service.impl;

import com.dtu.elibrary.model.Author;
import com.dtu.elibrary.payload.AuthorDto;
import com.dtu.elibrary.repository.AuthorRepository;
import com.dtu.elibrary.service.AuthorService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {
    ModelMapper mapper;
    AuthorRepository authorRepository;

    public AuthorServiceImpl(ModelMapper mapper, AuthorRepository authorRepository) {
        this.mapper = mapper;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<AuthorDto> getAllAuthor() {
        return authorRepository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    private AuthorDto mapToDto(Author author){
        return mapper.map(author, AuthorDto.class);
    }

    private Author mapToEntity(AuthorDto authorDto){
        return mapper.map(authorDto, Author.class);
    }
}
