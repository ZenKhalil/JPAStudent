package com.example.jpastudent23v2.repository;

import com.example.jpastudent23v2.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findAllByName(String name);
    List<Student> findAllByBornDate(LocalDate date);

}
