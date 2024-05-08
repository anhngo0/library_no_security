package com.example.libraryManagement.query.params;

import lombok.Data;

import java.util.Date;

@Data
public class GetProfileParams {
    private String keyword;
    private Date from;
    private Date to;
}
