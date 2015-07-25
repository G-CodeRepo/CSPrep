package com.csprep.csprep;

public class QNode {
	private String question;
    private String answer;
    private String false1;
    private String false2;
    private String userInput;
    private boolean correct;

    public QNode(String q, String a, String f1, String f2){
    	this.question = q;
        this.answer = a;
        this.false1 = f1;
        this.false2 = f2;
        this.userInput = "";
        this.correct = false;       
    }
    
    public String getQuestion(){
    	return this.question;
    }
    
    public void setQuestion(String q){
    	this.question = q;
    }
    
    public String getAnswer(){
    	return this.answer;
    }
    
    public void setAnswer(String a){
    	this.answer = a;
    }
    
    public String getFalseAnswer1(){
    	return this.false1;
    }
    
    public String getFalseAnswer2(){
    	return this.false2;
    }

    /*
    public boolean checkAnswer(String input){
        this.userInput = input;
        if(userInput.equals(this.answer)){
            correct = true;
        } else {
            correct = false;
        }
        return correct;
    }*/

}
