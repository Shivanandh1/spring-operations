package com.quizapplication.questionservice.Controller;


import com.quizapplication.questionservice.model.Question;
import com.quizapplication.questionservice.model.QuestionWrapper;
import com.quizapplication.questionservice.model.ResponseQuiz;
import com.quizapplication.questionservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @Autowired
    Environment environment;

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
//    @DeleteMapping("removeQuestion")
//    public String removeQuestion(@RequestParam int id){
//        return questionService.removeQuestion(id);
//    }
//    @DeleteMapping("removeAll")
//    public String removeAll(){
//        return questionService.removeQuestions();
//    }

    @GetMapping("generate")
    public  ResponseEntity<List<Integer>>  generateQuestionsForQuiz(@RequestParam String category , @RequestParam Integer numq){

        return questionService.generateQuestionsforQuiz(category,numq);
    }

    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> id){
        System.out.println(environment.getProperty("local.server.port"));
        return questionService.getQuestionsFromId(id);

    }

    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<ResponseQuiz> responseQuiz){
        return questionService.getScore(responseQuiz);
    }
}
