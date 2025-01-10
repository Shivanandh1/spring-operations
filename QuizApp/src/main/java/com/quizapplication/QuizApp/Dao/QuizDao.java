package com.quizapplication.QuizApp.Dao;

import com.quizapplication.QuizApp.model.Question;
import com.quizapplication.QuizApp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizDao extends JpaRepository<Quiz,Integer> {

    // List<Question> findRandomQuestionsByCategory(String category,String numQ) ;
}
