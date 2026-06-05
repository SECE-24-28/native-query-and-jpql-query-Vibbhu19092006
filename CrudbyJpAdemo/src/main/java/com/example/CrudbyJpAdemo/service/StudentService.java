package com.example.CrudbyJpAdemo.service;

import com.example.CrudbyJpAdemo.Dto.StudentDto;
import com.example.CrudbyJpAdemo.model.Student;
import com.example.CrudbyJpAdemo.repository.StudentRepo;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepo repo;

    // GET ALL STUDENTS
    public List<Student> getStudents() {
        return repo.findAll();
    }

    // ADD STUDENT
    public Student addStudent(Student student) {
        return repo.save(student);
    }

    // UPDATE STUDENT
    public Student updateStudent(Student student) {
        return repo.save(student);
    }

    // DELETE ALL STUDENTS
    public void deleteStudents() {
        repo.deleteAll();
    }

    // DELETE STUDENT BY ROLL NO
    public void deleteStudentbyrollno(int rno) {
        repo.deleteById(rno);
    }

    // FILTER USING DERIVED QUERY
    public List<Student> getStudentsCustom(
            String gender,
            String tech) {

        return repo.findByGenderAndTech(gender, tech);
    }

    // FIND BY TECH
    public List<Student> getStudentsbytech(String tech) {
        return repo.findByTech(tech);
    }

    // FILTER USING NATIVE QUERY
    public List<Student> filterStudents(
            String gender,
            String tech) {

        return repo.findByGenderandtec(gender, tech);
    }

    // FIND BY NAME
    public List<Student> getStudentsName(String name) {
        return repo.findByName(name);
    }

    // GET STUDENT BY ROLL NO
    public StudentDto getStudentsbyrollno(int rno) {

        Student s1 = repo.findById(rno)
                .orElseThrow(() ->
                        new RuntimeException("Student not found"));

        return convertStudentToDto(s1);
    }

    // CONVERT ENTITY TO DTO
    public StudentDto convertStudentToDto(Student s1) {

        StudentDto std = new StudentDto();

        std.setRno(s1.getRno());
        std.setName(s1.getName());
        std.setGender(s1.getGender());
        std.setTech(s1.getTech());
        std.setEmail(s1.getEmail());

        return std;
    }

    // ADD STUDENT USING DTO
    public StudentDto addStudents(@Valid StudentDto std) {

        Student student = repo.save(
                convertDtoToStudent(std));

        return convertStudentToDto(student);
    }

    // CONVERT DTO TO ENTITY
    public Student convertDtoToStudent(StudentDto std1) {

        Student s2 = new Student();

        s2.setRno(std1.getRno());
        s2.setName(std1.getName());
        s2.setGender(std1.getGender());
        s2.setTech(std1.getTech());
        s2.setEmail(std1.getEmail());

        return s2;
    }

    public Page<Student> getAllStudent(int page, int size) {
        return repo.findAll(PageRequest.of(page, size));
    }
}