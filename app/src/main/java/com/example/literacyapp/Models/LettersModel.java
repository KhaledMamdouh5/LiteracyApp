package com.example.literacyapp.Models;

public class LettersModel {
    Integer LettersImages;
    String LettersNames;

    public LettersModel(Integer LettersImages, String LettersNames){
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