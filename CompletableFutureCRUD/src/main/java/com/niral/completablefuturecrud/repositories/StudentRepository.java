package com.niral.completablefuturecrud.repositories;

import com.niral.completablefuturecrud.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
