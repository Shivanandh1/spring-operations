package com.quizapplication.quizservice.feign;

import com.quizapplication.quizservice.model.QuestionWrapper;
import com.quizapplication.quizservice.model.ResponseQuiz;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {

    @GetMapping("question/generate")
    public ResponseEntity<List<Integer>> generateQuestionsForQuiz(@RequestParam String category , @RequestParam Integer numq);

    @PostMapping("question/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> id);

    @PostMapping("question/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<ResponseQuiz> responseQuiz);

}
