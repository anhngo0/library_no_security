package com.example.libraryManagement.model.dto.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;

@Data
public class UpsertBookCategoryForm implements Serializable {
    @NotBlank(message = "{bookCategoryNameMustNotBeBlank}")
    String name;
    String note;
}
