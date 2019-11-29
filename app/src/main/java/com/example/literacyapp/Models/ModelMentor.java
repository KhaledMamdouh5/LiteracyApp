package com.example.literacyapp.Models;

public class ModelMentor {
    Integer studentAnswer;
    String question;

    public ModelMentor (Integer studentAnswer,String question){
        this.studentAnswer = studentAnswer;
        this.question = question;
    }

    public Integer getStudentAnswer() {
        return studentAnswer;
    }

    public String getQuestion() {
        return question;
    }
}
