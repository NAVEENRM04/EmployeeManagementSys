package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.microservices.Model.Feedback;

@Repository
public interface feedBackRepoInt extends JpaRepository<Feedback, Long> {
}
