package com.SumitKr.demo.StudentServer.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateStudentResponseDTO {

    private int id;
    private String name;
    private int age;
    private String department;
}