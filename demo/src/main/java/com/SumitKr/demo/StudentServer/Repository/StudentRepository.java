package com.SumitKr.demo.StudentServer.Repository;

import com.SumitKr.demo.StudentServer.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}