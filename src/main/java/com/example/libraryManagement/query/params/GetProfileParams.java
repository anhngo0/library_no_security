package com.example.libraryManagement.query.params;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GetProfileParams {
    private String keyword;
    private LocalDate from;
    private LocalDate to;
}
