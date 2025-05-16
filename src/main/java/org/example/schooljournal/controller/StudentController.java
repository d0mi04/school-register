// StudentController.java
package org.example.schooljournal.controller;

import org.example.schooljournal.entity.SchoolClass;
import org.example.schooljournal.entity.Student;
import org.example.schooljournal.repository.SchoolClassRepository;
import org.example.schooljournal.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SchoolClassRepository schoolClassRepository;

    @GetMapping
    public List<Student> getAll(@RequestParam(required = false) String name, @RequestParam(required = false) String surname, @RequestParam(required = false) String className) {
        if (className != null) {
            return studentRepository.findBySchoolClass_Name(className);
        } else if (name != null && surname != null) {
            return studentRepository.findByNameIgnoreCaseAndSurnameIgnoreCase(name, surname);
        } else {
            return studentRepository.findAll();
        }
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id) {
        return Optional.of(studentRepository.findById(id).orElseThrow()); // return studentRepository.findById(id);
    }

    // changed conception of searching:
//    @GetMapping("/search")
//    public List<Student> searchStudents(@RequestParam String name, @RequestParam String surname) {
//        return studentRepository.findByNameAndSurname(name, surname);
//    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        SchoolClass schoolClass = student.getSchoolClass();
        if (schoolClass != null) {
            // sprawdzenie, czy taka schoolClass już istnieje
            SchoolClass existing = schoolClassRepository.findByName(schoolClass.getName()).orElse(null);
            if(existing != null) {
                student.setSchoolClass(existing);
            } else {
                schoolClassRepository.save(schoolClass);
            }
        }
        return studentRepository.save(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
        Student student = studentRepository.findById(id).orElseThrow();
        student.setName(updatedStudent.getName());
        student.setSurname(updatedStudent.getSurname());

        if(updatedStudent.getSchoolClass() != null) {
            SchoolClass updatedClass = updatedStudent.getSchoolClass();
            SchoolClass existing = schoolClassRepository.findByName(updatedClass.getName()).orElse(null);
            if(existing != null) {
                student.setSchoolClass(existing);
            } else {
                schoolClassRepository.save(updatedClass);
                student.setSchoolClass(updatedClass);
            }
        }
        return studentRepository.save(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }
}