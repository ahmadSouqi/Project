package com.domin.dao;

import com.domin.model.Question;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by asouqi on 3/29/18.
 */
public class QuestionDAO extends TemplateDAO<Question,Long> {
    
    @Override
    public List<Question> get() throws SQLException {
        connectWithResultSet("select * from onlineExam.Question;");
        List<Question> questions=new ArrayList<>();

        while (set.next()){
            Question question=new Question();
            question.setId(set.getLong(1));
            question.setDescription(set.getString(2));
            question.setImg(set.getBytes(3));
            question.setQuestionType(Question.type.valueOf(set.getString(4)));
            question.setExpectedAnswer(getExpectedAnswer(question.getId()));
            question.setCorrectAnswer(set.getString(6));
            questions.add(question);
        }
        closeConnection();
        return questions;
    }

    @Override
    public void add(Question question) throws SQLException {
        connectWithPreparedStatement("INSERT INTO onlineExam.Question VALUE(?,?,?,?,?,?)");
        preparedStatement.setLong(1,question.getId());
        preparedStatement.setString(2,question.getDescription());
        preparedStatement.setBytes(3,question.getImg());
        preparedStatement.setString(4,question.getQuestionType().toString());
        preparedStatement.setString(6,question.getCorrectAnswer());
        preparedStatement.execute();
        closeConnection();

        addExpectedAnswer(question);
    }

    @Override
    public void edit(Question question,Long oldId) throws SQLException {
        connectWithPreparedStatement("update onlineExam.Question set description=?, img=?, type=?," +
              "correct_answer=? where id=?");
        preparedStatement.setString(1,question.getDescription());
        preparedStatement.setBytes(2,question.getImg());
        preparedStatement.setString(3,question.getQuestionType().toString());
        preparedStatement.setString(4,question.getCorrectAnswer());
        preparedStatement.setLong(5,oldId);
        preparedStatement.execute();
        closeConnection();

        editExpectedAnswer(question);
    }

    @Override
    public void delete(Long id) throws SQLException {
        connectWithPreparedStatement("delete from onlineExam.Question where id=?");
        preparedStatement.setLong(1,id);
        preparedStatement.execute();
        closeConnection();

        connectWithPreparedStatement("delete from onlineExam.expectedAnswer where question_id=?");
        preparedStatement.setLong(1,id);
        preparedStatement.execute();
        closeConnection();
    }

    private Map<Character,String> getExpectedAnswer(Long id) throws SQLException {
        connectWithResultSet(String.format("select branch,expected_answer from onlineExam.ExpectedAnswer" +
                                           "where question_id=%d",id));
        Map<Character,String> expectedAnswer=new HashMap<>();
        while (set.next()){
            expectedAnswer.put(set.getString(1).charAt(0),set.getString(2));
        }
        closeConnection();
        return expectedAnswer;
    }

    private void addExpectedAnswer(Question question) throws SQLException {
        connectWithPreparedStatement("INSERT INTO onlineExam.expectedAnswer VALUE(?,?,?)");
        setExpectedAnswer(question);
        closeConnection();
    }

    private void editExpectedAnswer(Question question) throws SQLException {
        connectWithPreparedStatement("update onlineExam.ExpectedAnswer set expected_answer=?" +
                "where question_id=? and branch=?");
        setExpectedAnswer(question);
        closeConnection();
    }

    private void setExpectedAnswer(Question question) throws SQLException {
        for (Map.Entry<Character,String> answer:question.getExpectedAnswer().entrySet()){
            preparedStatement.setString(1,answer.getKey().toString());
            preparedStatement.setLong(2,question.getId());
            preparedStatement.setString(3,answer.getValue());
            preparedStatement.execute();
        }
    }
}
