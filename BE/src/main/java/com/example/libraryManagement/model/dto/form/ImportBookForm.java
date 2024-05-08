package com.example.libraryManagement.model.dto.form;

import lombok.Data;

@Data
public class ImportBookForm {
    private String name;
    private String author;
    private String price;
    private String quantity;
}
