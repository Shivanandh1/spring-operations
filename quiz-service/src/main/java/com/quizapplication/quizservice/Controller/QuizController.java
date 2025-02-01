package com.quizapplication.quizservice.Controller;

import com.quizapplication.quizservice.model.QuestionWrapper;
import com.quizapplication.quizservice.model.QuizDto;
import com.quizapplication.quizservice.model.ResponseQuiz;
import com.quizapplication.quizservice.service.QuizService;
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
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto){

       return quizService.createQuiz(quizDto.getCategory(),quizDto.getNumQ(),quizDto.getTitle());
    }

    @GetMapping("getQuestions/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuestions(@PathVariable Integer id){

        return quizService.getQuestions(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submit(@PathVariable Integer id, @RequestBody List<ResponseQuiz> response){

        return quizService.calculateResults(id,response);
    }
}
