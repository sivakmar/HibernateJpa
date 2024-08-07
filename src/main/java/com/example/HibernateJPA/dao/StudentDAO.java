package com.example.HibernateJPA.dao;

import com.example.HibernateJPA.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);
    Student findById(Integer id);
    List<Student> findAll();
}
