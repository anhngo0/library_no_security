package com.example.libraryManagement.service.serviceImpl;

import com.example.libraryManagement.exeption.ResourceNotFoundException;
import com.example.libraryManagement.mapper.AccountMapper;
import com.example.libraryManagement.model.dto.AccountDto;
import com.example.libraryManagement.model.dto.form.UpsertAccountForm;
import com.example.libraryManagement.model.dto.fullInfo.AccountFullInfoDto;
import com.example.libraryManagement.model.entity.Account;
import com.example.libraryManagement.model.repository.AccountRepository;
import com.example.libraryManagement.query.params.GetAccountParams;
import com.example.libraryManagement.query.predicate.AccountPredicate;
import com.example.libraryManagement.service.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements IAccountService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    @Override
    public AccountDto createAccount(UpsertAccountForm upsertAccountForm) {
        Account account = accountMapper.toEntity(upsertAccountForm);
        account = accountRepository.save(account);
        return accountMapper.toDto(account);
    }

    @Override
    public Page<AccountFullInfoDto> getAccountFullInfoDto(GetAccountParams getAccountParams, Pageable pageable) {
        return accountRepository
                .findAll(AccountPredicate.getAccounts(getAccountParams), pageable)
                .map(accountMapper::toFullInfoDto);
    }

    @Override
    public Page<AccountDto> getAccountDto(GetAccountParams getAccountParams, Pageable pageable) {
        return null;
    }

    @Override
    public AccountDto updateAccount(UpsertAccountForm upsertAccountForm, Long id) {
        Account account = accountRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("resource not found"));
        Account updatedAccount = accountMapper.toEntity_update(upsertAccountForm, account);
        updatedAccount = accountRepository.save(updatedAccount);
        return accountMapper.toDto(updatedAccount);
    }

    @Override
    public void deleteAccount(Long id) throws ResourceNotFoundException {
           accountRepository.deleteById(id);
    }

}
