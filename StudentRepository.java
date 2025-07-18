package com.bala.Crud.repository;

import com.bala.Crud.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long>{
}
