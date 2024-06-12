package com.example.jpastudent23v2.controller;

import com.example.jpastudent23v2.JpaStudent23V2Application;
import com.example.jpastudent23v2.model.Student;
import com.example.jpastudent23v2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentRestController {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/")
    public String hello() {
        return "Du er i roden af JPAStudent01";
    }


    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/addstudent")
    public List<Student> addstudent() {
        Student std = new Student();
        std.setBornDate(LocalDate.now());
        std.setBornTime(LocalTime.now());
        List<Student> lst = studentRepository.findAll();
        std.setName("Autogenerated sz=" + lst.size());
        studentRepository.save(std);
        JpaStudent23V2Application.logger.info("gemmer i database");
        JpaStudent23V2Application.logger.info("student name={}, date={}", std.getName(), std.getBornDate());
        return studentRepository.findAll();
        //JpaStudent23V2Application.logger.atLevel(JpaStudent23V2Application.logger.T)
    }

    @GetMapping("students/{name}")
    public List<Student> getallstudentsbyname(@PathVariable String name) {
        return studentRepository.findAllByName(name);
    }

    @PostMapping("/student")
    @ResponseStatus(HttpStatus.CREATED)
    public Student postStudent(@RequestBody Student student) {
        System.out.println(student);
        studentRepository.save(student);
        return student;
    }

    @PutMapping("/studentx")
    public Student putStudentx(@RequestBody Student student) {
        //return studentRepository.save(student);
        Optional<Student> student1 = studentRepository.findById(student.getId());
        if (student1.isPresent()) {
            return studentRepository.save(student);
        } else {
            Student notStudent = new Student();
            notStudent.setName("NOT FOUND");
            return notStudent;
        }
    }

    @PutMapping("/student")
    public ResponseEntity<Student> putStudent(@RequestBody Student student) {
        //return studentRepository.save(student);
        Optional<Student> student1 = studentRepository.findById(student.getId());
        if (student1.isPresent()) {
            studentRepository.save(student);
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new Student(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        Optional<Student> student1 = studentRepository.findById(id);
        if (student1.isPresent()) {
            studentRepository.deleteById(id);
            return ResponseEntity.ok("Student delete");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found id=" + id);
        }
    }

}





