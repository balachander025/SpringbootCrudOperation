package com.bala.Crud.service;

import com.bala.Crud.model.Student;
import com.bala.Crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
    public void saveStudent(Student student){
        studentRepository.save(student);
    }
    public Optional<Student> getStudentById(Long id){
        return studentRepository.findById(id);
    }
    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }

}
