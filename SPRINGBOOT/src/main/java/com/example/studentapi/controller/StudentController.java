package com.example.studentapi.controller;

import com.example.studentapi.model.Student;
import com.example.studentapi.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    // GET all students
    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    // POST add student
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return service.addStudent(student);
    }

    // GET search by name
    @GetMapping("/search")
    public List<Student> searchStudents(@RequestParam String name) {
        return service.searchByName(name);
    }
}