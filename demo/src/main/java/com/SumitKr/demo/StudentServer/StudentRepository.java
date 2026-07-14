package com.SumitKr.demo.StudentServer;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository

public class StudentRepository {
    public Student save(Student student ) {
        System.out.println("Student Information saved");
        return student;
    }
}
