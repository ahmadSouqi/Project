package com.controller;

import com.domin.dao.UserDAO;
import com.domin.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by asouqi on 4/1/18.
 */
public class LogInController implements Controller {

    private String roll;

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user=new User(request.getParameter("txtUserName"),
                           request.getParameter("txtPassword"));

        try {
            if (isAuthenticate(user)){
                user.setRoll(roll);
                request.getSession().setAttribute("user",user);
                return String.format("/jsp/%s/index.jsp",roll);
            }
            else
                return "/index.jsp";
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    private boolean isAuthenticate(User user) throws SQLException {
        roll= new UserDAO().getRoll(user);

        if (roll!=null)
            return true;
        else
            return false;
    }
}
