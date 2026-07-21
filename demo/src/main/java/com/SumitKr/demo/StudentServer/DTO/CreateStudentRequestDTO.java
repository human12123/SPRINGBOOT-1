package com.SumitKr.demo.StudentServer.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateStudentRequestDTO {

    private String name;
    private int age;
    private String department;
}