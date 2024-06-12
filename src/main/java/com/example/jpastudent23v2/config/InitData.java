package com.example.jpastudent23v2.config;

import com.example.jpastudent23v2.model.Student;
import com.example.jpastudent23v2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

//@Component
public class InitData implements CommandLineRunner {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
        Student s1 = new Student();
        s1.setName("Bruce2");
        s1.setBornDate(LocalDate.of(2002,7,10));
        s1.setBornTime(LocalTime.of(11,2,3));
        studentRepository.save(s1);

        s1.setName("Viggo2");
        s1.setId(0);
        studentRepository.save(s1);
        System.out.println(s1);




    }
}
