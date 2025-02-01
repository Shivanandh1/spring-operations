package com.quizapplication.quizservice.service;

import com.quizapplication.quizservice.Dao.QuizDao;
import com.quizapplication.quizservice.feign.QuizInterface;
import com.quizapplication.quizservice.model.QuestionWrapper;
import com.quizapplication.quizservice.model.Quiz;
import com.quizapplication.quizservice.model.ResponseQuiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuizInterface  quizInterface;
//    @Autowired
//    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title){

        List<Integer> questionsCreate=quizInterface.generateQuestionsForQuiz(category,numQ).getBody();
            Quiz quiz=new Quiz();
            quiz.setTitle(title);
            quiz.setQuestionsIds(questionsCreate);
            quizDao.save(quiz);


        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }
    public ResponseEntity<List<QuestionWrapper>> getQuestions(Integer id){
        Quiz quizDaoById =quizDao.findById(id).get();
           List<Integer> quizNumId=quizDaoById.getQuestionsIds();

           ResponseEntity<List<QuestionWrapper>> questionsFromId=quizInterface.getQuestionsFromId(quizNumId);

        return questionsFromId;
    }

    public ResponseEntity<Integer> calculateResults(Integer id ,List<ResponseQuiz> response){
          //  Quiz quizById = quizDao.findById(id).get();
            ResponseEntity<Integer> score=quizInterface.getScore(response);

        return score;

    }
}
