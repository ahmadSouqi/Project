package com.servlet;

import com.controller.Controller;
import com.controller.ControllerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by asouqi on 4/1/18.
 */
@WebServlet(name = "FrontController", urlPatterns = {"*.action"})
public class FrontController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       handel(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        handel(request,response);
    }

    private void handel(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String dispatchUrl=null;
        String uri=request.getRequestURI();
        String action=uri.substring(uri.lastIndexOf('/')+1);

        Controller controller= ControllerFactory.getController(action);
        dispatchUrl= controller.handleRequest(request,response);

        if (dispatchUrl!=null){
            //response.sendRedirect(dispatchUrl);
            request.getRequestDispatcher(dispatchUrl).forward(request,response);
        }
        else
        {
            /* Dispatch To Error Page 404 */
        }
    }
}
