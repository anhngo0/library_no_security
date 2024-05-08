package com.example.libraryManagement.model.dto.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Date;

@Data
public class UpsertProfileForm {
    @NotBlank
    private String name;
    private Date DoB;
    @NotBlank
    private String CCCD_ID;
    private String address;
    @NotBlank
    private String phone;
    @NotBlank
    private String email;
}
