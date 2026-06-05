package com.example.CrudbyJpAdemo.controller;

import com.example.CrudbyJpAdemo.Dto.StudentDto;
import com.example.CrudbyJpAdemo.model.Student;
import com.example.CrudbyJpAdemo.service.StudentService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService service;

    // GET ALL STUDENTS
    @GetMapping("/student")
    public List<Student> getStudents() {
        return service.getStudents();
    }

    // ADD STUDENT USING DTO
   // @PostMapping("/student")
    //public StudentDto addStudents(
      //      @Valid @RequestBody StudentDto std) {

        //return service.addStudents(std);
    //}

    // UPDATE STUDENT
    @PutMapping("/student")
    public Student updateStudent(
            @RequestBody Student student) {

        return service.updateStudent(student);
    }

    // DELETE ALL STUDENTS
    @DeleteMapping("/student")
    public String deleteStudents() {

        service.deleteStudents();

        return "All students deleted";
    }

    // DELETE STUDENT BY ROLL NO
    @DeleteMapping("/student/{rno}")
    public String deleteStudentbyrollno(
            @PathVariable int rno) {

        service.deleteStudentbyrollno(rno);

        return "Student deleted";
    }

    // FILTER USING DERIVED QUERY
    @GetMapping("/student/custom")
    public List<Student> getStudentsCustom(
            @RequestParam String gender,
            @RequestParam String tech) {

        return service.getStudentsCustom(gender, tech);
    }

    // FIND BY TECH
    @GetMapping("/student/technology/{tech}")
    public List<Student> getStudentsbytech(
            @PathVariable String tech) {

        return service.getStudentsbytech(tech);
    }

    // FILTER USING NATIVE QUERY
    @GetMapping("/student/filter")
    public List<Student> filterStudents(
            @RequestParam String gender,
            @RequestParam String tech) {

        return service.filterStudents(gender, tech);
    }

    // FIND BY NAME
    @GetMapping("/student/name")
    public List<Student> getStudentsName(
            @RequestParam String name) {

        return service.getStudentsName(name);
    }

    // GET STUDENT BY ROLL NO
    @PostMapping("/student")
    public StudentDto addStudents(
            @Valid @RequestBody StudentDto std) {

        return service.addStudents(std);
    }
    @GetMapping("/student")
    public Page<Student> getAllStudent(@RequestParam("page") int page, @RequestParam("size") int size) {
        return service.getAllStudent(page,size);
    }
}