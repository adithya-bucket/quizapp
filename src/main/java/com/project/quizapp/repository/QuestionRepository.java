package com.project.quizapp.repository;

import com.project.quizapp.model.questions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<questions,Integer> {


    List<questions> findByCategory(String category);
    List<questions> findByCategoryAndLevel(String category,String level);
}
