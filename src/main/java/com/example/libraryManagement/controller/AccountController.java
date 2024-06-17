package com.example.libraryManagement.controller;

import com.example.libraryManagement.model.dto.AccountDto;
import com.example.libraryManagement.model.dto.form.UpsertAccountForm;
import com.example.libraryManagement.model.dto.fullInfo.AccountFullInfoDto;
import com.example.libraryManagement.query.params.GetAccountParams;
import com.example.libraryManagement.service.IAccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/account")
@RequiredArgsConstructor
public class AccountController {
    private final IAccountService accountService;
    private final PagedResourcesAssembler<AccountFullInfoDto> pagedResourcesAssembler;
    private final PagedResourcesAssembler<AccountDto> accountDtoPagedResourcesAssembler;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountDto> createAccount(@RequestBody @Valid UpsertAccountForm upsertAccountForm){
        return ResponseEntity.ok(accountService.createAccount(upsertAccountForm));
    }
    @GetMapping("/full-info")
    public ResponseEntity<PagedModel<EntityModel<AccountFullInfoDto>>> getFullInfoAccountDto(GetAccountParams getAccountParams, Pageable pageable){
        PagedModel<EntityModel<AccountFullInfoDto>> page = pagedResourcesAssembler.toModel(accountService.getAccountFullInfoDto(getAccountParams,pageable));
        return ResponseEntity.ok(page);
    }
    @GetMapping
    public ResponseEntity<PagedModel<EntityModel<AccountDto>>> getAccountDto(GetAccountParams getAccountParams, Pageable pageable){
        PagedModel<EntityModel<AccountDto>> page = accountDtoPagedResourcesAssembler.toModel(accountService.getAccountDto(getAccountParams,pageable));
        return ResponseEntity.ok(page);
    }
    @PutMapping("/{id}")
    public ResponseEntity<AccountDto> updateAccount(@RequestBody UpsertAccountForm upsertAccountForm, @PathVariable("id") Long id){
        return ResponseEntity.ok(accountService.updateAccount(upsertAccountForm, id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAccount( @PathVariable("id") Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.status(HttpStatus.OK).body("delete success");
    }
}
