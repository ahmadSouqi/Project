package com.domin.dao;

import com.domin.model.QuestionBank;

import java.sql.SQLException;
import java.util.*;

/**
 * Created by asouqi on 3/29/18.
 */
public class QuestionBankDAO extends TemplateDAO<QuestionBank,String>{

    @Override
    public List<QuestionBank> get() throws SQLException {
        connectWithResultSet("select * from onlineExam.QuestionBank");
        List<QuestionBank> questionBanks=new ArrayList<>();

        while (set.next()){
            QuestionBank questionBank=new QuestionBank();
            questionBank.setName(set.getString(1));
            questionBanks.add(questionBank);
        }
        closeConnection();
        return questionBanks;
    }

    @Override
    public void add(QuestionBank questionBank) throws SQLException {
        connectWithPreparedStatement("INSERT INTO onlineExam.QuestionBank VALUE(?)");
        preparedStatement.setString(1, questionBank.getName());
        preparedStatement.execute();
        closeConnection();
    }

    @Override
    public void edit(QuestionBank questionBank,String oldId)throws SQLException {
        connectWithPreparedStatement("update onlineExam.QuestionBank set name=? where name=?");
        preparedStatement.setString(1,questionBank.getName());
        preparedStatement.setString(2,oldId);
        preparedStatement.execute();
        closeConnection();
    }

    @Override
    public void delete(String id) throws SQLException {
        connectWithPreparedStatement("DELETE FROM onlineExam.QuestionBank WHERE name=?");
        preparedStatement.setString(1,id);
        preparedStatement.execute();
        closeConnection();
    }

    public List<String[]> getTeachers_Bank() throws SQLException{
        connectWithResultSet("select QuestionBank.name, QuestionBank_User.teacher_name" +
                " from QuestionBank_User" +
                " inner join QuestionBank on QuestionBank_User.bank_name= QuestionBank.name; ");
        List<String[]> questionBanks_Teachers=new ArrayList<>();

        while (set.next()){
            questionBanks_Teachers.add(new String[]{
                    set.getString(1),
                    set.getString(2)});
        }
        closeConnection();
        return questionBanks_Teachers;
    }

    public List<String> getTeacher_Banks(String name) throws SQLException{
        System.out.println("Im here.........."+name);
        connectWithResultSet(String.format("select bank_name from QuestionBank_User" +
                " where teacher_name='%s';",name));
        List<String> questionBanks_Teacher =new ArrayList<>();

        while (set.next()){
            questionBanks_Teacher.add(set.getString(1));
        }
        closeConnection();
        return questionBanks_Teacher;
    }


    public void addTeachers_Bank(String teacherName,String bankName) throws SQLException{
        connectWithPreparedStatement("INSERT INTO QuestionBank_User VALUE(?,?)");
        preparedStatement.setString(1, bankName);
        preparedStatement.setString(2, teacherName);
        preparedStatement.execute();
        closeConnection();
    }

    public void deleteTeachers_Bank(String teacherName,String bankName) throws SQLException{
        connectWithPreparedStatement("Delete from QuestionBank_User where bank_name=? and teacher_name=?");
        preparedStatement.setString(1, bankName);
        preparedStatement.setString(2, teacherName);
        preparedStatement.execute();
        closeConnection();
    }
}
