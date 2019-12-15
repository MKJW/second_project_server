package com.mkjw.second_project.service;

import com.mkjw.second_project.entity.Student;
import com.mkjw.second_project.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Nullable;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Nullable
    public Student findStudentById(String studentId) {
        return studentRepository.getOne(studentId);
    }
}
