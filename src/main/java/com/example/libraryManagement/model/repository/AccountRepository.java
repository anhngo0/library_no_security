package com.example.libraryManagement.model.repository;

import com.example.libraryManagement.model.entity.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends ParentRepository<Account,Long> {
}
