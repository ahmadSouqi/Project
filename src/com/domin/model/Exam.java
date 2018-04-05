package com.domin.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by asouqi on 3/25/18.
 */
public class Exam {

    private String title;
    private String author;
    private int questionNumber;
    private Date start;
    private Date end;
    private Map<Integer,String> groups;
    private List<String> students;
    private double passScore;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Map<Integer, String> getGroups() {
        return groups;
    }

    public void setGroups(Map<Integer, String> groups) {
        this.groups = groups;
    }

    public List<String> getStudents() {
        return students;
    }

    public void setStudents(List<String> students) {
        this.students = students;
    }

    public double getPassScore() {
        return passScore;
    }

    public void setPassScore(double passScore) {
        this.passScore = passScore;
    }
}
