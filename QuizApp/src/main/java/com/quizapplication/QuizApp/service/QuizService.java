package com.quizapplication.QuizApp.service;

import com.quizapplication.QuizApp.Dao.QuestionDao;
import com.quizapplication.QuizApp.Dao.QuizDao;
import com.quizapplication.QuizApp.model.Question;
import com.quizapplication.QuizApp.model.QuestionWrapper;
import com.quizapplication.QuizApp.model.Quiz;
import com.quizapplication.QuizApp.model.ResponseQuiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title){

        List<Question>questions= questionDao.findRandomQuestionsByCategory(category,numQ);
            Quiz quiz=new Quiz();
            quiz.setTitle(title);
            quiz.setQuestions(questions);
            quizDao.save(quiz);

        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }
    public ResponseEntity<List<QuestionWrapper>> getQuestions(Integer id){
        Optional<Quiz> quizDaoById =quizDao.findById(id);
        if (quizDaoById.isEmpty()) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Question> questionList=quizDaoById.get().getQuestions();
           List<QuestionWrapper> questionWrapperforUser= questionList.stream()
                   .map(question ->
                           new QuestionWrapper(question.getId(),question.getQuestionTitle(),question.getOption1(),
                   question.getOption2(), question.getOption3(),question.getOption4()))
                   .toList();

        return new ResponseEntity<>(questionWrapperforUser,HttpStatus.OK);

    }

    public ResponseEntity<Integer> calculateResults(Integer id ,List<ResponseQuiz> response){
        Optional<Quiz> quizById = quizDao.findById(id);
        List<Question> questions=quizById.get().getQuestions();
        int rightAnswer=0;
        int i=0;
        for(ResponseQuiz responseQuiz:response){
          if( responseQuiz.getResponse().equals(questions.get(i).getRightAnswer()) )
                rightAnswer++;

                i++;

        }

        return new ResponseEntity<>(rightAnswer,HttpStatus.OK);

    }
}
