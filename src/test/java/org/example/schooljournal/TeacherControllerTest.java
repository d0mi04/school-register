package org.example.schooljournal;

import org.example.schooljournal.controller.TeacherController;
import org.example.schooljournal.entity.Teacher;
import org.example.schooljournal.repository.TeacherRepository;
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

@WebMvcTest(TeacherController.class)
public class TeacherControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TeacherRepository teacherRepository;

    @Test
    public void shoudReturnAllTeachers() throws Exception {
        Teacher teacher = new Teacher();
        teacher.setId(1L);
        teacher.setName("Agata");
        teacher.setSurname("Ponczek");
        teacher.setSubject("Fizyka");

        when(teacherRepository.findAll()).thenReturn(List.of(teacher));
        mockMvc.perform(get("/teachers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Agata"))
                .andExpect(jsonPath("$[0].surname").value("Ponczek"))
                .andExpect(jsonPath("$[0].subject").value("Fizyka"));
    }
}
