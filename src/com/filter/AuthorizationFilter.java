package com.filter;

import com.domin.model.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by asouqi on 4/1/18.
 */
public class AuthorizationFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest)req;
        HttpServletResponse response=(HttpServletResponse)resp;
        HttpSession session = request.getSession();


        String area=getArea(request.getRequestURL().toString());
        boolean isGoingToLogIn= request.getRequestURI().equals("/login.action");
        User user=(User)session.getAttribute("user");
        //System.out.println(request.getRequestURL());
        if (isGoingToLogIn ||  (user!=null && user.getRoll().equals(area))){
            chain.doFilter(request, response);
        }
        else
            request.getRequestDispatcher("/index.jsp").forward(request,response);
            //response.sendRedirect("/index.jsp");
    }

    private String getArea(String url){
        int start_index=url.lastIndexOf("jsp/")+4;
        int end_index=url.lastIndexOf("/");
        return url.substring(start_index,end_index);
    }

    public void init(FilterConfig config) throws ServletException {}

}
