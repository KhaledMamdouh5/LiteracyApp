package com.example.literacyapp;

public class ModelLetters {
    Integer LettersImages;
    String LettersNames;

    public ModelLetters(Integer LettersImages, String LettersNames){
        this.LettersImages = LettersImages;
        this.LettersNames = LettersNames;
    }
    public Integer getLettersImages(){
        return LettersImages;
    }
    public String getLettersNames(){
        return LettersNames;
    }
}