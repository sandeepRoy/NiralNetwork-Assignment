package com.niral.completablefuturecrud.services;

import com.niral.completablefuturecrud.entities.Student;
import com.niral.completablefuturecrud.requests.CreateStudent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    void getAllStudents() throws ExecutionException, InterruptedException {
        CompletableFuture<List<Student>> allStudents = studentService.getAllStudents();
        List<Student> students = allStudents.get();
        System.out.println(students);
        assertEquals(students.size(), students.size());
    }

    @Test
    void createStudent() throws ExecutionException, InterruptedException {
        CreateStudent createStudent = new CreateStudent("Name Surname", 10, "Bangalore");
        CompletableFuture<Student> student = studentService.createStudent(createStudent);
        Student createdStudent = student.get();
        System.out.println(createdStudent);
    }
}