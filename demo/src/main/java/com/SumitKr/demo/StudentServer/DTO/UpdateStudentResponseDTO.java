package com.SumitKr.demo.StudentServer.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateStudentResponseDTO {

    private int id;
    private String name;
    private int age;
    private String department;
    private String email;
}