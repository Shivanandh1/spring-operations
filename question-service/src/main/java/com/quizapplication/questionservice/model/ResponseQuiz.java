package com.quizapplication.questionservice.model;


import lombok.Data;

@Data
public class ResponseQuiz {

    private int id;
    private String response;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public ResponseQuiz(int id, String response) {
        this.id = id;
        this.response = response;
    }
    public ResponseQuiz(){

    }
    public ResponseQuiz(String response, int id) {
        this.response = response;
        this.id = id;
    }
}
