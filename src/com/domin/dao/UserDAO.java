package com.domin.dao;

import com.domin.model.User;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by asouqi on 3/15/18.
 */
public class UserDAO extends TemplateDAO<User,String>{

    @Override
    public Set<User> get() throws SQLException {
        connectWithResultSet("select * from onlineExam.Users;");
        Set<User> users=new HashSet<>();

        while (set.next()){
            users.add(new User(set.getString(1),set.getString(2),
                    set.getString(3)));
        }
        closeConnection();
        return users;
    }

    public String getRoll(User user)throws SQLException{
        connectWithResultSet(String.format("select roll from onlineExam.Users " +
                "where UserName='%s' and Password='%s';",user.getUserName(),user.getPassword()));
        String roll=null;
        while (set.next()){
            roll=set.getString(1);
        }
        closeConnection();
        return roll;
    }

    @Override
    public void add(User user) throws SQLException {
        connectWithPreparedStatement("INSERT INTO onlineExam.Users VALUE(?,?,?)");
        preparedStatement.setString(1, user.getUserName());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getRoll());
        preparedStatement.execute();
        closeConnection();
    }

    @Override
    public void edit(User user,String oldId)throws SQLException {
        connectWithPreparedStatement("update onlineExam.Users set UserName=?, Password=?," +
                "roll=? where UserName=?;");
        preparedStatement.setString(1, user.getUserName());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getRoll());
        preparedStatement.setString(4, oldId);
        preparedStatement.execute();
        closeConnection();
    }

    @Override
    public void delete(String id) throws SQLException {
        connectWithPreparedStatement("DELETE FROM onlineExam.Users WHERE UserName=?");
        preparedStatement.setString(1,id);
        preparedStatement.execute();
        closeConnection();
    }
}
