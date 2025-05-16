package org.example.schooljournal.controller;

import org.example.schooljournal.entity.SchoolClass;
import org.example.schooljournal.repository.SchoolClassRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classes")
public class SchoolClassController {
    private final SchoolClassRepository classRepository;

    public SchoolClassController(SchoolClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    @GetMapping
    public List<SchoolClass> getAllClasses() {
        return classRepository.findAll();
    }

    @PostMapping
    public SchoolClass addClass(@RequestBody SchoolClass schoolClass) {
        return classRepository.save(schoolClass);
    }
}
