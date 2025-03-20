package com.project.quizapp.controller;

import com.project.quizapp.model.questions;
import com.project.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;
    @GetMapping("allQuestions")
    public List<questions> getAllQuestion(){
        return questionService.getAllQuestion();
    }

    @GetMapping("category/{category}")
    public List<questions> getCategoryBasedQuestion(@PathVariable String category){
        return questionService.getCategoryBasedQuestion(category);
    }

    @GetMapping("category/{category}/{level}")
    public List<questions> getCategoryBasedQuestionAndLevel(@PathVariable String category,@PathVariable String level){
        return questionService.getCategoryBasedQuestionAndLevel(category,level);
    }

    @PostMapping("add")
    public String addQuestion(@RequestBody questions questions){
        return questionService.addQuestion(questions);
    }

    @PutMapping("update/{id}")
    public String updateQuestion(@RequestBody questions updatedquestions){
        return questionService.updateQuestion(updatedquestions);
    }

    @DeleteMapping("delete/{id}")
    public String deleteQuestion(@PathVariable int id){
        return questionService.deleteQuestion(id);
    }
}
