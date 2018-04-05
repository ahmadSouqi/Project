package com.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by asouqi on 3/22/18.
 */
public interface Controller {
    String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
