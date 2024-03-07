package com.niral.completablefuturecrud.services;

import com.niral.completablefuturecrud.entities.Student;
import com.niral.completablefuturecrud.repositories.StudentRepository;
import com.niral.completablefuturecrud.requests.CreateStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public CompletableFuture<List<Student>> getAllStudents() {
        CompletableFuture<List<Student>> studentCompletableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            try {
                Thread.sleep(1000);
                List<Student> all = studentRepository.findAll();
                System.out.println("StudentService : 24 -> " + Thread.currentThread().getName());
                studentCompletableFuture.complete(all);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return null;
        });
        return studentCompletableFuture;
    }

    public CompletableFuture<Student> createStudent(CreateStudent createStudent) {
        CompletableFuture<Student> studentCompletableFuture = new CompletableFuture<>();
        Executors.newCachedThreadPool().submit(() -> {
            System.out.println("StudentService : 38 -> " + Thread.currentThread().getName());
            Student student = new Student();
            student.setName(createStudent.getName());
            student.setAge(createStudent.getAge());
            student.setCity(createStudent.getCity());

            Student createdStudent = studentRepository.save(student);

            studentCompletableFuture.complete(createdStudent);
        });
        return studentCompletableFuture;
    }
}