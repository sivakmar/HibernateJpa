package com.example.HibernateJPA.dao;

import com.example.HibernateJPA.entity.Student;

public interface StudentDAO {
    void save(Student student);
    Student findById(Integer id);
}
