package com.example.libraryManagement.model.repository;

import com.example.libraryManagement.model.entity.BookClassNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookClassNumberRepository extends ParentRepository<BookClassNumber, Long> {
}
