package com.example.literacyapp.Models;

public class FirstExerciseModel {
    Integer WordsImages;
    String Words;

    public FirstExerciseModel(Integer wordsImages, String words){
        this.WordsImages = wordsImages;
        this.Words = words;
    }
    public Integer getWordsImages(){
        return WordsImages;
    }
    public String getWords(){
        return Words;
    }
}