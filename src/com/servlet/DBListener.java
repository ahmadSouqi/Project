package com.servlet;

import com.domin.dao.TemplateDAO;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by asouqi on 3/26/18.
 */
@WebListener
public class DBListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        String url=servletContextEvent.getServletContext().getInitParameter("DB_Url");
        String userName=servletContextEvent.getServletContext().getInitParameter("DB_UserName");
        String passWord=servletContextEvent.getServletContext().getInitParameter("DB_Password");
        TemplateDAO.setConnection(url,userName,passWord);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
