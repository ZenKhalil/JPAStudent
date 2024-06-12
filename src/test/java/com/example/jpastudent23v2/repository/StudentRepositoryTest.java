package com.example.jpastudent23v2.repository;

import com.example.jpastudent23v2.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    StudentRepository studentRepository;

    @Test
    void testOneTime() {
        List<Student> lst = studentRepository.findAllByName("viggo");
        assertEquals(0, lst.size());
    }

    @Test
    void testOneTime2() {
        List<Student> lst = studentRepository.findAllByName("viggo");
        assertEquals(0, lst.size());
    }

}