package com.project.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.student;

public interface studentRepo extends JpaRepository<student, Integer>{

}
