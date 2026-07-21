package com.SumitKr.demo.StudentServer.Service;

import com.SumitKr.demo.StudentServer.DTO.CreateStudentRequestDTO;
import com.SumitKr.demo.StudentServer.DTO.CreateStudentResponseDTO;
import com.SumitKr.demo.StudentServer.DTO.UpdateStudentRequestDTO;
import com.SumitKr.demo.StudentServer.DTO.UpdateStudentResponseDTO;
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
    public CreateStudentResponseDTO studentValidate(CreateStudentRequestDTO dto) {

        Student student = mapToStudent(dto);

        student = studentRepository.save(student);

        return mapToResponseDTO(student);
    }

    // Get Student
    public Student getStudentById(int id) throws Exception {

        return studentRepository
                .findById(id)
                .orElseThrow(() -> new Exception());
    }

    // Update Student
    public UpdateStudentResponseDTO updateStudent(
            int id,
            UpdateStudentRequestDTO dto) {

        Student student = studentRepository.findById(id).orElse(null);

        if (student == null) {
            return null;
        }

        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setUpdatedAt(LocalDateTime.now());

        studentRepository.save(student);

        return mapToUpdateResponseDTO(student);
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

    // Request DTO -> Entity
    private Student mapToStudent(CreateStudentRequestDTO dto) {

        Student student = new Student();

        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setDepartment(dto.getDepartment());
        student.setEmail(dto.getEmail());

        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());

        return student;
    }

    // Entity -> Create Response DTO
    private CreateStudentResponseDTO mapToResponseDTO(Student student) {

        CreateStudentResponseDTO response = new CreateStudentResponseDTO();

        response.setId(student.getId());
        response.setName(student.getName());
        response.setAge(student.getAge());
        response.setDepartment(student.getDepartment());
        response.setEmail(student.getEmail());

        return response;
    }

    // Entity -> Update Response DTO
    private UpdateStudentResponseDTO mapToUpdateResponseDTO(Student student) {

        UpdateStudentResponseDTO response = new UpdateStudentResponseDTO();

        response.setId(student.getId());
        response.setName(student.getName());
        response.setAge(student.getAge());
        response.setDepartment(student.getDepartment());
        response.setEmail(student.getEmail());

        return response;
    }
}