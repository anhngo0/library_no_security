package com.example.libraryManagement.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = "CCCD_ID", name = "CCCD_ID")
})
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private LocalDateTime DoB;

    @Column(nullable = false,length = 12)
    private String CCCD_ID;

    private String address;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String email;
}
