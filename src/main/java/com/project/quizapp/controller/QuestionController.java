package com.project.quizapp.controller;

import com.project.quizapp.model.questions;
import com.project.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public List<questions> getAllQuestion() {
        return questionService.getAllQuestion();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<questions>> getCategoryBasedQuestionAndLevel(@PathVariable String category, @RequestParam(required = false) Optional<String> levels) {
        List<questions> questions = levels.map(level -> questionService.getCategoryBasedQuestionAndLevel(category, level))
                .orElseGet(() -> questionService.getCategoryBasedQuestion(category));
        if (questions.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(questions);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody questions questions) {
        questionService.addQuestion(questions);
        return ResponseEntity.status(HttpStatus.CREATED).body("Created Successfully");
    }

    @PutMapping("update/{id}")
    public String updateQuestion(@RequestBody questions updatedquestions) {
        return questionService.updateQuestion(updatedquestions);
    }

    @DeleteMapping("delete/{id}")
    public String deleteQuestion(@PathVariable int id) {
        return questionService.deleteQuestion(id);
    }
}
