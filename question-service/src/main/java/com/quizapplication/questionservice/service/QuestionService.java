package com.quizapplication.questionservice.service;

import com.quizapplication.questionservice.Dao.QuestionDao;
import com.quizapplication.questionservice.model.Question;
import com.quizapplication.questionservice.model.QuestionWrapper;
import com.quizapplication.questionservice.model.ResponseQuiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestions(){
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);

    }
    public ResponseEntity<List<Question>> getQuestionsByCategory(String category){
        try {
        return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
        }
        return  new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);

    }
    public String addQuestion(Question question){
        questionDao.save(question);
        return "success";
    }

    public String removeQuestion(int id) {
        questionDao.deleteById(id);
        return "deleted all questions";
    }

    public String removeQuestions() {
        questionDao.deleteAll();
        return "success deleted";
    }

    public ResponseEntity<List<Integer>> generateQuestionsforQuiz(String category, Integer numq) {
           List<Integer> questions=questionDao.findRandomQuestionsByCategory(category,numq);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> id) {
        List<QuestionWrapper> wrapperQuestions=new ArrayList<>();
        List<Question> questions=new ArrayList<>();

        for(Integer ids:id){
            questions.add(questionDao.findById(ids).get());
        }

       for(Question question:questions){
         QuestionWrapper questionWrapper=new QuestionWrapper();
         questionWrapper.setId(question.getId());
         questionWrapper.setQuestionTitle(question.getQuestionTitle());
         questionWrapper.setOption1(question.getOption1());
         questionWrapper.setOption2(question.getOption2());
         questionWrapper.setOption3(question.getOption3());
         questionWrapper.setOption4(question.getOption4());
           wrapperQuestions.add(questionWrapper);

       }
        return new ResponseEntity<>(wrapperQuestions,HttpStatus.OK);
    }

    public ResponseEntity<Integer> getScore(List<ResponseQuiz> responseQuiz) {

        int rightAnswer=0;
        for(ResponseQuiz response :responseQuiz){
            Question question=questionDao.findById(response.getId()).get();
            if(response.getResponse().equals(question.getRightAnswer()) )
                rightAnswer++;
        }

        return new ResponseEntity<>(rightAnswer,HttpStatus.OK);
    }
}
