package com.student.student.service;

import com.student.student.exception.ResourceNotFoundException;
import com.student.student.model.Student;
import com.student.student.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudent(String id) throws ResourceNotFoundException {
        return studentRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Student Not Found")
        );
    }

    @Override
    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student updateStudent(String id, Student newStudent) {
        return studentRepository.findById(id)
                .map(student -> {
                    BeanUtils.copyProperties(newStudent, student, "id");
                    return studentRepository.save(student);
                })
                .orElseGet(() -> {
                    newStudent.setId(id);
                    return studentRepository.save(newStudent);
                });
    }
}
