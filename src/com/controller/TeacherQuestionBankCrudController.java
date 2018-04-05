package com.controller;

import com.domin.dao.QuestionBankDAO;
import com.domin.model.QuestionBank;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by asouqi on 4/4/18.
 */
public class TeacherQuestionBankCrudController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try {
            String operation = request.getParameter("operation");
            if (operation!=null){
                switch (operation){
                    case "add":
                        new QuestionBankDAO().addTeachers_Bank(request.getParameter("txtNameTeacher"),
                                request.getParameter("txtNameBank"));
                        break;
                    case "delete":
                        new QuestionBankDAO().deleteTeachers_Bank(request.getParameter("txtNameTeacher"),
                                request.getParameter("txtNameBank"));
                        break;
                }
            }
            request.setAttribute("Teachers_QuestionBanks",new QuestionBankDAO().getTeachers_Bank());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "/jsp/admin/teacherQuestionBank.jsp";
    }
}
