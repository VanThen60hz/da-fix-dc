package com.dtu.elibrary.repository;

import com.dtu.elibrary.model.BorrowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface    BorrowEntityRepository extends JpaRepository<BorrowEntity, Integer> {
}
