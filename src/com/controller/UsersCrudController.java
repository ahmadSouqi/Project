package com.controller;

import com.domin.dao.UserDAO;
import com.domin.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by asouqi on 4/4/18.
 */
public class UsersCrudController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user;
        try {
            String operation = request.getParameter("operation");
            if (operation!=null){
            switch (operation){
            case "add":
                user= getUser(request);
                new UserDAO().add(user);
                break;
            case "update":
                user= getUser(request);
                new UserDAO().edit(user,null);
                break;
            case "delete":
                new UserDAO().delete(request.getParameter("id"));
                break;
        }
        }
            request.setAttribute("Users",new UserDAO().get());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "/jsp/admin/users.jsp";
    }

    private User getUser(HttpServletRequest request) {
        return new User(request.getParameter("txtName"),
                request.getParameter("txtPassword"),
                request.getParameter("txtRoll"));
    }
}
