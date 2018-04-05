package com.domin.model;

import java.util.List;

/**
 * Created by asouqi on 3/25/18.
 */
public class QuestionBank {

    private String name;
    private List<String> teachers;
    private QuestionGroup[] questionGroups;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<String> teachers) {
        this.teachers = teachers;
    }

    public QuestionGroup[] getQuestionGroups() {
        return questionGroups;
    }

    public void setQuestionGroups(QuestionGroup[] questionGroups) {
        this.questionGroups = questionGroups;
    }
}
