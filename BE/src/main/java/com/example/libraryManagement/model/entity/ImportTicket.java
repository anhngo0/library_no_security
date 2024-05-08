package com.example.libraryManagement.model.entity;

import com.example.libraryManagement.model.dto.form.ImportBookForm;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ImportTicket extends Ticket{
    private Integer totalQuantity;
    private Double totalPrice;
    private String supplier;
    private String import_way;
}
