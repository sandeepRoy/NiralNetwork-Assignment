package com.niral.completablefuturecrud.controllers;

import com.niral.completablefuturecrud.entities.Student;
import com.niral.completablefuturecrud.requests.CreateStudent;
import com.niral.completablefuturecrud.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents() throws ExecutionException, InterruptedException {
        System.out.println("StudentController : 25 -> " + Thread.currentThread().getName());
        CompletableFuture<List<Student>> allStudents = studentService.getAllStudents();
        List<Student> students = allStudents.get();
        return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody CreateStudent createStudent) throws ExecutionException, InterruptedException {
        System.out.println("StudentController : 32 -> " + Thread.currentThread().getName());
        CompletableFuture<Student> completableFuture = studentService.createStudent(createStudent);
        Student student = completableFuture.get();
        return new ResponseEntity<Student>(student, HttpStatus.CREATED);
    }
}
