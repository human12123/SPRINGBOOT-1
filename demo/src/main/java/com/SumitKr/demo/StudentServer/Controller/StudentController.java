package com.SumitKr.demo.StudentServer.Controller;

import com.SumitKr.demo.StudentServer.DTO.CreateStudentRequestDTO;
import com.SumitKr.demo.StudentServer.DTO.CreateStudentResponseDTO;
import com.SumitKr.demo.StudentServer.Entity.Student;
import com.SumitKr.demo.StudentServer.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<?> storeStudent(
            @RequestBody CreateStudentRequestDTO createStudentRequestDTO) {

        CreateStudentResponseDTO result =
                studentService.studentValidate(createStudentRequestDTO);

        if(result == null){
            return ResponseEntity.badRequest().body("Invalid Student");
        }

        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id){
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable int id){

        Student result = studentService.deleteStudent(id);

        if(result==null){
            return ResponseEntity.badRequest().body("Student Not Found");
        }

        return ResponseEntity.ok("Student deleted");
    }

}