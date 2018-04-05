package com.domin.dao;

import com.domin.model.Exam;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExamDAO extends TemplateDAO<Exam,String> {

    @Override
    public List<Exam> get() throws SQLException {
        connectWithResultSet("select * from onlineExam.exam;");
        List<Exam> exams=new ArrayList<>();

        while (set.next()){
            Exam exam=new Exam();
            exam.setTitle(set.getString(1));
            exam.setAuthor(set.getString(2));
            exam.setStart(set.getDate(3));
            exam.setEnd(set.getDate(4));
            exam.setQuestionNumber(set.getInt(5));
            exam.setPassScore(set.getDouble(6));
            exams.add(exam);
        }
        closeConnection();
        return exams;
    }

    @Override
    public void add(Exam exam) throws SQLException {
        connectWithPreparedStatement("INSERT INTO onlineExam.exam VALUE(?,?,?,?,?,?)");
        preparedStatement.setString(1, exam.getTitle());
        preparedStatement.setString(2, exam.getAuthor());
        preparedStatement.setDate(3, (Date) exam.getStart());
        preparedStatement.setDate(4, (Date) exam.getEnd());
        preparedStatement.setInt(5,exam.getQuestionNumber());
        preparedStatement.setDouble(6,exam.getPassScore());
        preparedStatement.execute();
        closeConnection();
    }

    @Override
    public void edit(Exam exam,String oldId) throws SQLException {
        connectWithPreparedStatement("update onlineExam.exam set author=?, start=?, end=?, " +
                "questionNumber=?, pass_score=? where title=?");
        preparedStatement.setString(1, exam.getAuthor());
        preparedStatement.setDate(2, (Date) exam.getStart());
        preparedStatement.setDate(3, (Date) exam.getEnd());
        preparedStatement.setInt(4,exam.getQuestionNumber());
        preparedStatement.setDouble(5,exam.getPassScore());
        preparedStatement.setString(6, exam.getTitle());
        preparedStatement.execute();
        closeConnection();
    }

    @Override
    public void delete(String id) throws SQLException {
        connectWithPreparedStatement("delete from onlineExam.exam where title=?;");
        preparedStatement.setString(1, id);
        preparedStatement.execute();
        closeConnection();
    }
}
