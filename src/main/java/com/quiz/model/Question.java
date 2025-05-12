package com.quiz.model;

public class Question {
    private int id;
    private String questionText;
    private String[] options;
    private int correctAnswer;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getQuestionText() { return questionText; }
    public void setQuestionText(String questionText) { this.questionText = questionText; }
    public String[] getOptions() { return options; }
    public void setOptions(String[] options) { this.options = options; }
    public int getCorrectAnswer() { return correctAnswer; }
    public void setCorrectAnswer(int correctAnswer) { this.correctAnswer = correctAnswer; }
}