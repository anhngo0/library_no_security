package com.example.libraryManagement.query.params;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class GetProfileParams {
    private String keyword;
    private LocalDateTime from;
    private LocalDateTime to;
}
