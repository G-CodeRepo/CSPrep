package com.csprep.csprep;

import java.io.Serializable;

public class UserRecord implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String highestScore;
    private String language;
    private String level;

    public UserRecord(String firstName, String lastName, String email, String password) {
        this.firstName  = firstName;
        this.lastName   = lastName;
        this.email      = email;
        this.password   = password;
    }

    public UserRecord() {
        // default
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getPassword() {
        return this.password;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNewHighScore(String newRecord) {
        this.highestScore = newRecord;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getHighScore() {
        return this.highestScore;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return this.language;
    }
}
