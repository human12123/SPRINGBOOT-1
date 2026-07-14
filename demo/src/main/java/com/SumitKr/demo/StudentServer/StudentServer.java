package com.SumitKr.demo.StudentServer;

import com.SumitKr.demo.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentServer {
    //1. Store the student
    @PostMapping("/Create")
    public String storeStudent(Student student) {
        return """
                id : 1
                Name : Sumit Kumar
                Department : CSE
                Age : 20
                """;
    }
    //2. Read the Student with id

    //3. Update the student information
    //4. delete the student information

}
