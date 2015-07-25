package com.csprep.csprep;


import java.io.Serializable;
import java.util.List;

public class Package implements Serializable {
    private int correct = 0;
    private int incorrect = 0;
    private String[] questionData;
    private String category;
    private List<String[]> questionList;
    private int currentIndex;
    private int maxIndex;
    private int currentQuestionNumber;

    public Package(String category, List<String[]> questionList) {
        this.category = category;
        this.questionList = questionList;
        this.currentIndex = 0;
        this.maxIndex = questionList.size();
    }

    public void increaseCorrectScore() {
        this.correct++;
    }

    public void increaseIncorrectScore() {
        this.incorrect++;
    }

    public String getCorrectScore() {
        return String.valueOf(this.correct);
    }

    public String getIncorrectScore() {
        return String.valueOf(this.incorrect);
    }

    public boolean getQuestion(int index) {
        this.currentIndex = index;
        if (index >= this.maxIndex) {
            return false;
        } else {
            this.addQuestionData(questionList.get(index));
            this.currentQuestionNumber = index + 1; // because index starts at 0
            return true;
        }
    }
    public int getCurrentIndex() {
        return this.currentIndex;
    }


    private void addQuestionData(String [] questionData) {
        this.questionData = new String[questionData.length];
        for (int i = 0; i < questionData.length; i++) {
            this.questionData[i] = questionData[i];
        }
    }

    public String getCategory() {
        return this.questionData[0];
    }

    public String getQuestion() {
        return this.questionData[1];
    }


    public String getCorrectAnswer() {
        return this.questionData[2];
    }

    public String[] getIncorrectAnswers() {
        String[] incorrect = {this.questionData[3], this.questionData[4]};
        return incorrect;
    }

    public boolean done() {
        if (this.currentIndex == this.maxIndex-1) { // no more questions
            return true;
        } else {
            return false;        // questions still exist
        }
    }

    public List<String[]> getQuestionList() {
        return this.questionList;
    }

    public void reset() {
        this.correct = 0;
        this.incorrect = 0;
        this.getQuestion(0);    // reset to the first question
    }

    public int getCurrentQuestionNumber() {
        return this.currentQuestionNumber;
    }

    public int getMaxQuestions() {
        return this.maxIndex;
    }



}
