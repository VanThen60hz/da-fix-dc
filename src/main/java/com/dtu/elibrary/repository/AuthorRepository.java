package com.dtu.elibrary.repository;

import com.dtu.elibrary.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AuthorRepository extends JpaRepository<Author, String> {
    Author findByAuthor(String name);
}
