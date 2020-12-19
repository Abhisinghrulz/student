package com.student.student.service;

import com.student.student.exception.ResourceNotFoundException;
import com.student.student.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StudentService {
    public Student createStudent(Student student);
    public List<Student> getAllStudent();
    public Student getStudent(String id) throws ResourceNotFoundException;
    public void deleteStudent(String id);
    public Student updateStudent(String id, Student newStudent);
}
