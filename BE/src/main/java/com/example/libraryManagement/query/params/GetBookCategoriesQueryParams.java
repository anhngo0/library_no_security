package com.example.libraryManagement.query.params;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class GetBookCategoriesQueryParams {
    private String keyword;
}
