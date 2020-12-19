package com.student.student.controller;

import com.student.student.exception.ResourceNotFoundException;
import com.student.student.model.Student;
import com.student.student.model.Subject;
import com.student.student.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentControllerTest {
    @Mock
    StudentService studentService;

    @InjectMocks
    StudentController studentController;

    private List<Student> studentList;
    private Student student;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        studentList = Arrays.asList(new Student("abc123", "Abhishek", "1", Collections.singletonList(new Subject("Computer"))));
        student = new Student("abc123", "Abhishek", "1", Collections.singletonList(new Subject("Computer")));
    }

    @Test
    public void getAllRestaurant() {
        Mockito.when(studentService.getAllStudent()).thenReturn(studentList);
        List<Student> allStudent = studentController.getAllStudent().getBody();
        assertEquals(studentList, allStudent);
    }

    @Test
    public void getRestaurantById() throws ResourceNotFoundException {
        Mockito.when(studentService.getStudent(Mockito.anyString())).thenReturn(student);
        Student actualStudent = studentController.getStudentById("ab123").getBody();
        assertEquals(student, actualStudent);
    }

    @Test
    public void addStudent() {
        Mockito.when(studentService.createStudent(student)).thenReturn(student);
        assertEquals(student, studentController.addStudent(student).getBody());
    }

    @Test
    public void deleteStudent() {
        Mockito.doNothing().when(studentService).deleteStudent("ab123");
        assertEquals("Student Successfully deleted", studentController.deleteStudentById("ab123").getBody());
    }

    @Test
    public void updateStudent() {
        Mockito.when(studentService.updateStudent("ab123", student)).thenReturn(student);
        Student student1 = studentController.updateStudent("ab123", this.student).getBody();
        assertEquals(student1, student);
    }

}