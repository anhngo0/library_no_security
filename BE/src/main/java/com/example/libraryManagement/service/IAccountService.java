package com.example.libraryManagement.service;

import com.example.libraryManagement.model.dto.AccountDto;
import com.example.libraryManagement.model.dto.form.UpsertAccountForm;
import com.example.libraryManagement.model.dto.fullInfo.AccountFullInfoDto;
import com.example.libraryManagement.query.params.GetAccountParams;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IAccountService {
    AccountDto createAccount(UpsertAccountForm upsertAccountForm);

    Page<AccountFullInfoDto> getAccountFullInfoDto(GetAccountParams getAccountParams, Pageable pageable);

    Page<AccountDto> getAccountDto(GetAccountParams getAccountParams, Pageable pageable);

    AccountDto updateAccount(UpsertAccountForm upsertAccountForm, Long id);

    void deleteAccount(Long id);

    void setUnenabledAccount(Long id);
}
