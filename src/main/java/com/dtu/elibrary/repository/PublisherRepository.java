package com.dtu.elibrary.repository;

import com.dtu.elibrary.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PublisherRepository extends JpaRepository<Publisher, String> {
    Publisher findByPublisher(String name);
}
