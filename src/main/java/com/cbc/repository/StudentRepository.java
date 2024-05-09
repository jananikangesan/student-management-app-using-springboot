package com.cbc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cbc.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
