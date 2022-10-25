package com.robeil.eregistrarsecurity.repository;


import com.robeil.eregistrarsecurity.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query(value = "select s from Student s where s.firstName like : search")
    Student findStudentByFirstNameContaining(String search);

}
