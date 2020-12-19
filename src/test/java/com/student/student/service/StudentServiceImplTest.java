package com.student.student.service;

import com.student.student.exception.ResourceNotFoundException;
import com.student.student.model.Student;
import com.student.student.model.Subject;
import com.student.student.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;

class StudentServiceImplTest {
    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentServiceImpl studentService;

    private List<Student> studentList;
    private Student student;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        studentList = Arrays.asList(new Student("abc123", "Abhishek", "1", Collections.singletonList(new Subject("Computer"))));
        student = new Student("abc123", "Abhishek", "1", Collections.singletonList(new Subject("Computer")));
    }

    @Test
    public void createStudent() {
        Mockito.when(studentRepository.save(student)).thenReturn(student);
        Student student1 = studentService.createStudent(this.student);
        assertEquals(student, student1);
    }

    @Test
    public void getAllStudent() {
        Mockito.when(studentRepository.findAll()).thenReturn(studentList);
        List<Student> student1List = studentService.getAllStudent();
        assertEquals(studentList, student1List);
    }

    @Test
    public void getStudent() throws ResourceNotFoundException {
        Mockito.when(studentRepository.findById("ab123")).thenReturn(Optional.of(student));
        Student student1 = studentService.getStudent("ab123");
        assertEquals(student, student1);
    }

    @Test
    public void deleteStudent(){
        Mockito.doNothing().when(studentRepository).deleteById("ab123");
        studentService.deleteStudent("ab123");
        Mockito.verify(studentRepository, times(1)).deleteById("ab123");
    }
}