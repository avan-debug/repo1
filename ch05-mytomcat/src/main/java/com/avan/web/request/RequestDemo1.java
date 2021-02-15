package com.avan.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/requestDemo1")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getMethod());

        System.out.println(req.getContextPath());

        System.out.println(req.getServletPath());

        System.out.println(req.getProtocol());

        System.out.println(req.getQueryString());

        System.out.println(req.getRequestURI());

        System.out.println(req.getRequestURL());

        System.out.println(req.getRemoteAddr());

        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String str = headerNames.nextElement();
            System.out.println(str + " : " +
                    req.getHeader(str));
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

