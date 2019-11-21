package com.example.literacyapp;

public class ModelThirdExercise {
    String answer;
    String question;
    int image;

    public ModelThirdExercise(int image , String question , String answer) {
        this.answer = answer;
        this.question = question;
        this.image = image;
    }


    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}