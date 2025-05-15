// StudentRepository.java
package org.example.schooljournal.repository;

import org.example.schooljournal.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByClassNumber(int classNumber);
    List<Student> findByNameAndSurname(String name, String surname);
}
