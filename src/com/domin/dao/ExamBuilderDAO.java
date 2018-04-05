package com.domin.dao;

import java.sql.SQLException;
import java.util.*;

public class ExamBuilderDAO {

    public String title;
    public class SelectedGroup{

        private String groupName;
        private Integer polling;


        public String getGroupName() {
            return groupName;
        }

        public void setGroupName(String groupName) {
            this.groupName = groupName;
        }

        public Integer getPolling() {
            return polling;
        }
        public void setPolling(Integer polling) {
            this.polling = polling;
        }

    }


    public class SelectedGroupDAO extends TemplateDAO<SelectedGroup,String>{

        @Override
        public List<SelectedGroup> get() throws SQLException {
            connectWithPreparedStatement("select pulling,question_group_name from " +
                    "onlineExam.exam_questiongroup where exam_title=?;");
            List<SelectedGroup> selectedGroups=new ArrayList<>();
            while (set.next()){
                SelectedGroup selectedGroup=new SelectedGroup();
                selectedGroup.setPolling(set.getInt(1));
                selectedGroup.setGroupName(set.getString(2));
                selectedGroups.add(selectedGroup);
            }
            closeConnection();
            return selectedGroups;
        }

        @Override
        public void add(SelectedGroup selectedGroup) throws SQLException {
            connectWithPreparedStatement("INSERT INTO onlineExam.exam_questiongroup VALUE(?,?,?)");
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, selectedGroup.groupName);
            preparedStatement.setInt(3,selectedGroup.polling);
            preparedStatement.execute();
            closeConnection();
        }

        @Override
        public void edit(SelectedGroup selectedGroup,String oldId) throws SQLException {
            connectWithPreparedStatement("update onlineExam.exam_questiongroup set pulling=? where" +
                    "exam_title=? and question_group_name=?;");
            preparedStatement.setInt(1,selectedGroup.polling);
            preparedStatement.setString(2,title);
            preparedStatement.setString(3,selectedGroup.groupName);
            preparedStatement.execute();
            closeConnection();
        }

        @Override
        public void delete(String id) throws SQLException {
            connectWithPreparedStatement("delete from onlineExam.exam_questiongroup " +
                    "where exam_title=?;");
            preparedStatement.setString(1, id);
            preparedStatement.execute();
            closeConnection();
        }

    }

    public class SelectedStudentDAO extends TemplateDAO<String,String>{
        @Override
        public List<String> get() throws SQLException {
            connectWithResultSet(String.format("select user_name onlineExam.exam_users" +
                    "where exam_title=?",title));
            List<String> users=new ArrayList<>();
            while (set.next()){
                users.add(set.getString(1));
            }
            closeConnection();
            return users;
        }

        @Override
        public void add(String userName) throws SQLException {
            connectWithPreparedStatement("INSERT INTO onlineExam.exam_users VALUE(?,?)");
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, userName);
            preparedStatement.execute();
            closeConnection();
        }

        @Override
        public void edit(String userName,String oldId) throws SQLException {
            connectWithPreparedStatement("update onlineExam.exam_users set exam_title=?" +
                    "where user_name=?");
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, userName);
            preparedStatement.execute();
            closeConnection();
        }

        @Override
        public void delete(String id) throws SQLException {
            connectWithPreparedStatement("delete from onlineExam.exam_users " +
                    "where where user_name=?;");
            preparedStatement.setString(1, id);
            preparedStatement.execute();
        }
    }
}
