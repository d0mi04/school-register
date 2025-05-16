package org.example.schooljournal.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class SchoolClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name; // 2A, 5C

    // każdy uczeń należy do jednej klasy, a klasa może mieć wielu uczniów
    @OneToMany(mappedBy = "schoolClass")
    private List<Student> students;

    // gettery i settery:

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
