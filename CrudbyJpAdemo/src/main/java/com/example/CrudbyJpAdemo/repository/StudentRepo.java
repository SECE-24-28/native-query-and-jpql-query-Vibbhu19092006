package com.example.CrudbyJpAdemo.repository;

import com.example.CrudbyJpAdemo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Integer> {


    List<Student> findByGenderAndTech(String gender, String tech);


    List<Student> findByTech(String tech);


    @Query(
            nativeQuery = true,
            value = "SELECT * FROM student WHERE gender = :gender AND tech = :tech"
    )
    List<Student> findByGenderandtec(
            @Param("gender") String gender,
            @Param("tech") String tech
    );


    @Query("SELECT s FROM Student s WHERE s.name = :name")
    List<Student> findByName(@Param("name") String name);

}