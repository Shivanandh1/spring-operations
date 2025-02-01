package com.quizapplication.QuizApp.Controller;

import com.quizapplication.QuizApp.model.Question;
import com.quizapplication.QuizApp.service.QuestionService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){

         return questionService.getAllQuestions();
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getCategory(@PathVariable("category") String category){
            return questionService.getQuestionsByCategory(category);
    }
    @PostMapping("addQuestion")
    public String addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }
    @DeleteMapping("removeQuestion")
    public String removeQuestion(@RequestParam int id){
        return questionService.removeQuestion(id);
    }
    @DeleteMapping("removeAll")
    public String removeAll(){
        return questionService.removeQuestions();
    }
}
