package com.example.libraryManagement.model.repository;

import com.example.libraryManagement.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends ParentRepository<Book,Long> {
}
