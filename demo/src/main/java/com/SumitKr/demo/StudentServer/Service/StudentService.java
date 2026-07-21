package com.SumitKr.demo.StudentServer.Service;

import com.SumitKr.demo.StudentServer.DTO.CreateStudentRequestDTO;
import com.SumitKr.demo.StudentServer.DTO.CreateStudentResponseDTO;
import com.SumitKr.demo.StudentServer.Entity.Student;
import com.SumitKr.demo.StudentServer.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Create Student
    public CreateStudentResponseDTO studentValidate(CreateStudentRequestDTO createStudentRequestDTO) {

        Student student = mapToStudent(createStudentRequestDTO);

        student = studentRepository.save(student);

        return mapToResponseDTO(student);
    }

    // Get Student by ID
    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    // Update Student
    public Student updateStudent(int id, Student student) {

        Student existingStudent = studentRepository.findById(id).orElse(null);

        if (existingStudent == null) {
            return null;
        }

        existingStudent.setName(student.getName());
        existingStudent.setAge(student.getAge());
        existingStudent.setDepartment(student.getDepartment());
        existingStudent.setUpdatedAt(LocalDateTime.now());

        return studentRepository.save(existingStudent);
    }

    // Delete Student
    public Student deleteStudent(int id) {

        Student student = studentRepository.findById(id).orElse(null);

        if (student == null) {
            return null;
        }

        studentRepository.delete(student);

        return student;
    }

    // Convert Request DTO -> Entity
    private Student mapToStudent(CreateStudentRequestDTO dto) {

        Student student = new Student();

        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setDepartment(dto.getDepartment());
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());

        return student;
    }

    // Convert Entity -> Response DTO
    private CreateStudentResponseDTO mapToResponseDTO(Student student) {

        CreateStudentResponseDTO response = new CreateStudentResponseDTO();

        response.setId(student.getId());
        response.setName(student.getName());
        response.setAge(student.getAge());
        response.setDepartment(student.getDepartment());

        return response;
    }
}