package com.capstone.AdminAuthen.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class SignUpDTO {
    private Integer id;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String name;

    @NotNull
    private String password;

    @NotNull
    private String phonenumber;

    @NotNull
    private boolean gender;

    @NotNull
    private Date birthday;

}
