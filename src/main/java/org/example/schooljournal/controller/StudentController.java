// StudentController.java
package org.example.schooljournal.controller;

import org.example.schooljournal.entity.Student;
import org.example.schooljournal.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository repository;

    @GetMapping
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id) {
        return repository.findById(id);
    }

    @GetMapping("/class/{classNumber}")
    public List<Student> getStudentsByClass(@PathVariable int classNumber) {
        return repository.findByClassNumber(classNumber);
    }

    @GetMapping("/search")
    public List<Student> searchStudents(@RequestParam String name, @RequestParam String surname) {
        return repository.findByNameAndSurname(name, surname);
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return repository.save(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student updated) {
        return repository.findById(id).map(student -> {
            student.setName(updated.getName());
            student.setSurname(updated.getSurname());
            student.setClassNumber(updated.getClassNumber());
            return repository.save(student);
        }).orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        repository.deleteById(id);
    }
}