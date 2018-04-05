package com.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
/**
 * Created by asouqi on 4/1/18.
 */
public class AuthenticationFilter implements Filter {
    public void destroy() {}

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest)req;
        HttpServletResponse response=(HttpServletResponse)resp;
        HttpSession session = request.getSession();

        boolean isLogIn= session.getAttribute("user")!=null;
        boolean isGoingToLogIn= request.getRequestURI().equals("/login.action");

        //session.invalidate();
        System.out.println(request.getRequestURL());
        if (isLogIn || isGoingToLogIn) {
            chain.doFilter(request, response);
        }
        else{
            //response.sendRedirect("/index.jsp");
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }
    }

    public void init(FilterConfig config) throws ServletException {}

}
