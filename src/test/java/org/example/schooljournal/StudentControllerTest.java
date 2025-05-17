package org.example.schooljournal;

import org.example.schooljournal.controller.StudentController;
import org.example.schooljournal.entity.Student;
import org.example.schooljournal.repository.SchoolClassRepository;
import org.example.schooljournal.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StudentController.class)
public class StudentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentRepository studentRepository;

    @MockBean
    private SchoolClassRepository schoolClassRepository;

    @Test
    public void shouldReturnAllStudents() throws Exception {
        Student student = new Student();
        student.setId(1L);
        student.setName("Anna");
        student.setSurname("Kowalska");

        when(studentRepository.findAll()).thenReturn(List.of(student));

        mockMvc.perform(get("/students"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Anna"))
                .andExpect(jsonPath("$[0].surname").value("Kowalska"));
    }
}
