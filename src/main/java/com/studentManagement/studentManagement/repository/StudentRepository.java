package com.studentManagement.studentManagement.repository;

import com.studentManagement.studentManagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findById(int id);
    Student findStudentByName(String name);
}
