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

    public CreateStudentResponseDTO studentValidate(CreateStudentRequestDTO dto) {

        Student student = mapToStudent(dto);

        student = studentRepository.save(student);

        return mapToResponseDTO(student);
    }

    public Student getStudentById(int id) throws Exception {

        return studentRepository
                .findById(id)
                .orElseThrow(() -> new Exception());
    }

    public Student updateStudent(int id, Student student) {

        Student existingStudent =
                studentRepository.findById(id).orElse(null);

        if (existingStudent == null) {
            return null;
        }

        existingStudent.setName(student.getName());
        existingStudent.setAge(student.getAge());
        existingStudent.setDepartment(student.getDepartment());
        existingStudent.setUpdatedAt(LocalDateTime.now());

        return studentRepository.save(existingStudent);
    }

    public Student deleteStudent(int id) {

        Student student =
                studentRepository.findById(id).orElse(null);

        if (student == null) {
            return null;
        }

        studentRepository.delete(student);

        return student;
    }

    private Student mapToStudent(CreateStudentRequestDTO dto) {

        Student student = new Student();

        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setDepartment(dto.getDepartment());

        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());

        return student;
    }

    private CreateStudentResponseDTO mapToResponseDTO(Student student) {

        CreateStudentResponseDTO response =
                new CreateStudentResponseDTO();

        response.setId(student.getId());
        response.setName(student.getName());
        response.setAge(student.getAge());
        response.setDepartment(student.getDepartment());

        return response;
    }
}