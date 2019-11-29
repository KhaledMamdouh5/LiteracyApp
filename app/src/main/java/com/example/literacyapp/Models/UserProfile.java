package com.example.literacyapp.Models;

import java.util.List;

public class UserProfile {

    String userType;
    String userId;
    String username;
    List<String> sentImages;


    public UserProfile() {
    }

    public String getUserType() {
        return userType;
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public List<String> getSentImages() {
        return sentImages;
    }

    public UserProfile(String userType, String userId, String username, List<String> sentImages) {
        this.userType = userType;
        this.userId = userId;
        this.username = username;
        this.sentImages = sentImages;
    }

}

