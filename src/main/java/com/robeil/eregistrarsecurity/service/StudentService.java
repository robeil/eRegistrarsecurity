package com.robeil.eregistrarsecurity.service;


import com.robeil.eregistrarsecurity.model.Student;
import org.springframework.data.domain.Page;

public interface StudentService {

    void addNewStudent(Student student);
    Page<Student> getAllStudents(int pageNo);
    void updateStudent(Student student);
    void deleteStudentById(Long studentId);
    Student findStudentByFirsName(String search);

}
