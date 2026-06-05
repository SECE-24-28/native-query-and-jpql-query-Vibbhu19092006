package com.example.CrudbyJpAdemo.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class StudentDto {

    private int rno;

    @NotBlank(message = "Name cannot be empty")
    private String name;

    private String gender;

    private String tech;

    @Email(message = "Invalid email format")
    private String email;
}