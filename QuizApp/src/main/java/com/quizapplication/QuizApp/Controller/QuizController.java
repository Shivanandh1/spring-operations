package com.quizapplication.QuizApp.Controller;

import com.quizapplication.QuizApp.model.QuestionWrapper;
import com.quizapplication.QuizApp.model.ResponseQuiz;
import com.quizapplication.QuizApp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){

       return quizService.createQuiz(category,numQ,title);
    }

    @GetMapping("getQuestions/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuestions(@PathVariable Integer id){

        return quizService.getQuestions(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submit(@PathVariable Integer id, @RequestBody List<ResponseQuiz> response){

        return  quizService.calculateResults(id,response);
    }
}
