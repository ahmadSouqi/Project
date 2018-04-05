package com.controller;

import com.domin.dao.CRUDOperations;
import com.domin.dao.DAOFactory;
import com.domin.dao.QuestionBankDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by asouqi on 4/5/18.
 */
public class CrudController implements Controller {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CRUDOperations crud= DAOFactory.getDAOObject("",request);

        String operation = request.getParameter("operation");

        if (operation!=null){
            switch (operation){
                case "add":

                    break;
                case "update":

                    break;
                case "delete":

                    break;
            }
        }

        return null;
    }
}
