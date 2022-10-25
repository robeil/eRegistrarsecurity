package com.robeil.eregistrarsecurity.service.impl;


import com.robeil.eregistrarsecurity.model.Student;
import com.robeil.eregistrarsecurity.repository.StudentRepository;
import com.robeil.eregistrarsecurity.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void addNewStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Page<Student> getAllStudents(int pageNo) {
        return studentRepository.findAll(PageRequest.of(pageNo,5, Sort.Direction.ASC,"firstName"));

    }

    @Override
    public void updateStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public Student findStudentByFirsName(String search) {
        return studentRepository.findStudentByFirstNameContaining(search);
    }
}
