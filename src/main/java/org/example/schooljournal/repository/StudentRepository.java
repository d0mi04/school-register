// StudentRepository.java
package org.example.schooljournal.repository;

import org.example.schooljournal.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
//    List<Student> findByNameAndSurname(String name, String surname);
    List<Student> findByNameIgnoreCaseAndSurnameIgnoreCase(String name, String surname);
    List<Student> findBySchoolClass_Name(String name);
}
