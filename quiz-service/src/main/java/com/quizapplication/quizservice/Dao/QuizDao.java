package com.quizapplication.quizservice.Dao;

import com.quizapplication.quizservice.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizDao extends JpaRepository<Quiz,Integer> {

    // List<Question> findRandomQuestionsByCategory(String category,String numQ) ;
}
