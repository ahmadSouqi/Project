package com.domin.model;

import java.util.Map;

/**
 * Created by asouqi on 3/27/18.
 */
public class Result {

    private Long id;
    private String studentName;
    private String examTitle;
    private Map<Integer,String> questionAnswers;
    private double score;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getExamTitle() {
        return examTitle;
    }

    public void setExamTitle(String examTitle) {
        this.examTitle = examTitle;
    }

    public Map<Integer, String> getQuestionAnswers() {
        return questionAnswers;
    }

    public void setQuestionAnswers(Map<Integer, String> questionAnswers) {
        this.questionAnswers = questionAnswers;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
