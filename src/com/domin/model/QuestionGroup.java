package com.domin.model;


/**
 * Created by asouqi on 3/25/18.
 */
public class QuestionGroup {

    public enum level{Hard,Medium,Easy};

    private String name;
    private String teacherName;
    private level groupLevel;
    private Long questionNumber;
    private String questionBankName;
    private Question[] questions;
    /* Later...
    private int pulling;

    public HashMap<Long, Question> getQuestions(){
        final Random r=new Random();
        final HashMap<Long,Question> selectedQuestions=new HashMap<>();

        for (int i = 0; i < pulling; i++) {
            long num=r.nextInt(this.questions.length);
            while (selectedQuestions.containsKey(num)){
                num=r.nextInt(this.questions.length);
            }
            selectedQuestions.put(num,null);
        }
        return selectedQuestions;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Long getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(Long questionNumber) {
        this.questionNumber = questionNumber;
    }

    public Question[] getQuestions() {
        return questions;
    }

    public void setQuestions(Question[] questions) {
        this.questions = questions;
    }

    public String getQuestionBankName() {
        return questionBankName;
    }

    public void setQuestionBankName(String questionBankName) {
        this.questionBankName = questionBankName;
    }

    public level getGroupLevel() {
        return groupLevel;
    }

    public void setGroupLevel(level groupLevel) {
        this.groupLevel = groupLevel;
    }
}
