package com.dtu.elibrary.repository;

import com.dtu.elibrary.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface BookRepository extends JpaRepository<Book, Integer> {
    Page<Book> findByTitleContaining(String title, Pageable pageable);
}
