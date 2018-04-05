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
public class QuestionBanksCrudController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionBank questionBank;
        try {
            String operation = request.getParameter("operation");
            if (operation!=null){
                switch (operation){
                    case "add":
                        questionBank= getQuestionBank(request);
                        new QuestionBankDAO().add(questionBank);
                        break;
                    case "update":
                        questionBank= getQuestionBank(request);
                        new QuestionBankDAO().edit(questionBank,request.getParameter("oldName"));
                        break;
                    case "delete":
                        new QuestionBankDAO().delete(request.getParameter("id"));
                        break;
                }
            }
            request.setAttribute("QuestionsBanks",new QuestionBankDAO().get());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "/jsp/admin/questionBanks.jsp";
    }

    private QuestionBank getQuestionBank(HttpServletRequest request) {
        QuestionBank questionBank = new QuestionBank();
        questionBank.setName(request.getParameter("txtName"));
        return questionBank;
    }
}
