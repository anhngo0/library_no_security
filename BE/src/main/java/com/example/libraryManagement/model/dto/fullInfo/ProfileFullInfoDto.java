package com.example.libraryManagement.model.dto.fullInfo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ProfileFullInfoDto implements Serializable {
    private Long id;
    private String name;
    private Date DoB;
    private String CCCD_ID;
    private String address;
    private String phone;
    private String email;
}
