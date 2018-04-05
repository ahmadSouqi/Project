package com.domin.dao;

import com.domin.model.Result;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultDAO extends TemplateDAO<Result,Long> {
    @Override
    public List<Result> get() throws SQLException {
        connectWithResultSet("select * from onlineExam.result;");
        List<Result> results=new ArrayList<>();

        while (set.next()){
            Result result=new Result();
            result.setStudentName(set.getString(1));
            result.setExamTitle(set.getString(2));
            result.setId(set.getLong(3));
            result.setScore(set.getDouble(4));
            results.add(result);
        }
        closeConnection();
        return results;
    }

    @Override
    public void add(Result result) throws SQLException {
        connectWithPreparedStatement("INSERT INTO onlineExam.result VALUE(?,?,?)");
        preparedStatement.setString(1, result.getStudentName());
        preparedStatement.setString(2, result.getExamTitle());
        preparedStatement.setLong(3,   result.getId());
        preparedStatement.execute();
        closeConnection();
    }

    public Map<Integer,String> getQuestionsAnswer() throws SQLException {
        connectWithPreparedStatement("select question_id,answer form onlineExam.result_question" +
                " where result_id=?");
        Map<Integer,String> questionAnswers=new HashMap<>();
        while (set.next()){
            questionAnswers.put(set.getInt(1),set.getString(2));
        }
        closeConnection();
        return questionAnswers;
    }

    public void addSelectedQuestionStudent(List<Long> questionsID,Long resultId) throws SQLException {
        connectWithPreparedStatement("INSERT INTO onlineExam.result_question(result_id,question_id) VALUE(?,?)");
        for (Long qId:questionsID) {
            preparedStatement.setLong(1,resultId);
            preparedStatement.setLong(2,qId);
            preparedStatement.execute();
        }
        closeConnection();
    }

    public void editQuestionsAnswer(Map<Integer,String> questionAnswers,Long resultId) throws SQLException {
        connectWithPreparedStatement("update onlineExam.result_question set answer=? " +
                "where result_id=? and question_id=?;");
        for (Map.Entry<Integer,String> q:questionAnswers.entrySet()){
            preparedStatement.setString(1, q.getValue());
            preparedStatement.setLong(2,   resultId);
            preparedStatement.setLong(3,   q.getKey());// question_id
            preparedStatement.execute();
        }
        closeConnection();
    }

    public void addMarkToExamResult(Double score,Long resultId) throws SQLException {
        connectWithPreparedStatement("update onlineExam.result set score=? where result_id=?");
        preparedStatement.setDouble(1,   score);
        preparedStatement.setLong(2,   resultId);
        preparedStatement.execute();
        closeConnection();
    }

    @Override
    public void edit(Result result,Long oldId) throws SQLException {}

    @Override
    public void delete(Long id) throws SQLException {}
}
