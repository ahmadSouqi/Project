package com.domin.model;

import java.util.List;
import java.util.Map;

/**
 * Created by asouqi on 3/25/18.
 */
public class Question {

    public enum type{ONE_ANSWER,MULTIPLE_ANSWER};

    private long id;
    private String description;
    private byte[] img;
    private type questionType;
    private Map<Character,String> expectedAnswer;
    private String correctAnswer;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public type getQuestionType() {
        return questionType;
    }

    public void setQuestionType(type questionType) {
        this.questionType = questionType;
    }

    public Map<Character, String> getExpectedAnswer() {
        return expectedAnswer;
    }

    public void setExpectedAnswer(Map<Character, String> expectedAnswer) {
        this.expectedAnswer = expectedAnswer;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
