package com.example.literacyapp;

public class ModelFirstExercise {
    Integer WordsImages;
    String Words;

    public ModelFirstExercise(Integer wordsImages, String words){
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