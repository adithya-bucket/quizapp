package com.project.quizapp.service;

import com.project.quizapp.model.questions;
import com.project.quizapp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;
    public List<questions> getAllQuestion() {
        return questionRepository.findAll(Sort.by("id"));
    }

    public List<questions> getCategoryBasedQuestion(String category) {
        return questionRepository.findByCategory(category);
    }

    public String addQuestion(questions questions) {
        questionRepository.save(questions);
        return "Added question successfully";
    }

    public List<questions> getCategoryBasedQuestionAndLevel(String category, String level) {
        return questionRepository.findByCategoryAndLevel(category, level);
    }

    public String updateQuestion(questions updatedquestions) {
        questionRepository.save(updatedquestions);
        return  "updated successfully";
    }

    public String deleteQuestion(int id) {
        questionRepository.deleteById(id);
        return "delete successfully";
    }
}
