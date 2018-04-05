package com.controller;

import com.domin.dao.QuestionBankDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by asouqi on 4/5/18.
 */
public class TeacherQuestionBank implements Controller{
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setAttribute("TeacherBanks",new QuestionBankDAO().getTeacher_Banks(request.getParameter("bankName")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "jsp/teacher/index.jsp";
    }
}
