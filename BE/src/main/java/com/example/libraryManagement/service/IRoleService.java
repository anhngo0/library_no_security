package com.example.libraryManagement.service;

import com.example.libraryManagement.model.dto.RoleDto;
import com.example.libraryManagement.model.dto.form.UpsertRoleForm;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IRoleService {
    List<RoleDto> getAllRole();
    RoleDto getRoleById(Long id);

    RoleDto createRole(UpsertRoleForm upsertRoleForm);

    RoleDto updateRole(UpsertRoleForm upsertRoleForm, Long id);

    void deleteRoleById(Long id);
}
