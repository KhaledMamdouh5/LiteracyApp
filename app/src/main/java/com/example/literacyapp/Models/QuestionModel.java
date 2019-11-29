package com.example.literacyapp.Models;


public class QuestionModel {

    String url;
    String username;
    String status;
    String letter;

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public QuestionModel() {
    }

    public QuestionModel(String url, String username, String status , String letter) {
        this.url = url;
        this.username = username;
        this.status = status;
        this.letter = letter ;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getStatus() {
        return status;
    }
}

