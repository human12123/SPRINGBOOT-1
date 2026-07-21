package com.SumitKr.demo.StudentServer.Controller;

import com.SumitKr.demo.StudentServer.DTO.CreateStudentRequestDTO;
import com.SumitKr.demo.StudentServer.DTO.CreateStudentResponseDTO;
import com.SumitKr.demo.StudentServer.DTO.UpdateStudentRequestDTO;
import com.SumitKr.demo.StudentServer.DTO.UpdateStudentResponseDTO;
import com.SumitKr.demo.StudentServer.Entity.Student;
import com.SumitKr.demo.StudentServer.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> storeStudent(
            @Valid @RequestBody CreateStudentRequestDTO dto) {

        CreateStudentResponseDTO response =
                studentService.studentValidate(dto);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/getStudent/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable int id) throws Exception {

        Student student = studentService.getStudentById(id);

        return ResponseEntity.ok(student);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudent(
            @PathVariable int id,
            @Valid @RequestBody UpdateStudentRequestDTO dto) {

        UpdateStudentResponseDTO result =
                studentService.updateStudent(id, dto);

        if (result == null) {
            return ResponseEntity.badRequest().body("Student Not Found");
        }

        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable int id) {

        Student result = studentService.deleteStudent(id);

        if (result == null) {
            return ResponseEntity.badRequest().body("Student Not Found");
        }

        return ResponseEntity.ok("Student deleted");
    }
}