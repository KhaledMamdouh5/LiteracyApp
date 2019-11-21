package com.example.literacyapp;

public class ModelFourthExercise {
    Integer WordsImages;
    String title;
    boolean status;

    public ModelFourthExercise(Integer wordsImages) {
        this.WordsImages = wordsImages;
    }

    public Integer getWordsImages() {
        return WordsImages;
    }

    public ModelFourthExercise(String title, boolean status) {
        this.title = title;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public boolean isStatus() {
        return status;
    }

}