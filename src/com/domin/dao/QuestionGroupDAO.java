package com.domin.dao;

import com.domin.model.QuestionGroup;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by asouqi on 3/29/18.
 */
public class QuestionGroupDAO extends TemplateDAO<QuestionGroup,String> {

    @Override
    public List<QuestionGroup> get() throws SQLException {
        connectWithResultSet("select * from onlineExam.QuestionGroup;");
        List<QuestionGroup> questionGroups=new ArrayList<>();

        while (set.next()){
            QuestionGroup questionGroup=new QuestionGroup();
            questionGroup.setName(set.getString(1));
            questionGroup.setTeacherName(set.getString(2));
            questionGroup.setGroupLevel(QuestionGroup.level.valueOf(set.getString(3)));
            questionGroups.add(questionGroup);
        }
        closeConnection();
        return questionGroups;
    }

    @Override
    public void add(QuestionGroup questionGroup) throws SQLException {
        connectWithPreparedStatement("INSERT INTO onlineExam.QuestionGroup VALUE(?,?,?,?)");
        preparedStatement.setString(1,questionGroup.getName());
        preparedStatement.setString(2,questionGroup.getTeacherName());
        preparedStatement.setString(3,questionGroup.getGroupLevel().toString());
        preparedStatement.setLong(4,0);
        preparedStatement.execute();
        closeConnection();
    }

    @Override
    public void edit(QuestionGroup questionGroup,String oldId) throws SQLException {

        if (questionGroup.getQuestionNumber()==null) {

            editAll_Information(questionGroup);
        }
        else{
            increaseQuestionNumber(questionGroup);
        }
    }

    @Override
    public void delete(String id) throws SQLException {
       connectWithPreparedStatement("delete from onlineExam where name=?;");
       preparedStatement.setString(1,id);
       closeConnection();
    }

    private void editAll_Information(QuestionGroup questionGroup) throws SQLException {
        connectWithPreparedStatement("update onlineExam.QuestionGroup set name=?, teacherName=?," +
                "level=?, question_bank_name=? where name=?;");
        preparedStatement.setString(1, questionGroup.getName());
        preparedStatement.setString(2, questionGroup.getTeacherName());
        preparedStatement.setString(3, questionGroup.getGroupLevel().toString());
        preparedStatement.execute();
        closeConnection();
    }

    private void increaseQuestionNumber(QuestionGroup questionGroup) throws SQLException {
        connectWithPreparedStatement("update onlineExam.QuestionGroup set number_of_question=? where name=?;");
        preparedStatement.setLong(1,questionGroup.getQuestionNumber());
        preparedStatement.setString(2,questionGroup.getTeacherName());
        preparedStatement.execute();
        closeConnection();
    }
}
