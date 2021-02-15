package com.avan.web.servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName ServletContextDemo1
 * @Description TODO
 * @Author xinyusong
 * @Date 2021/2/9 15:20
 * @Version 1.0
 **/
@WebServlet("/servletDemo1")
public class ServletContextDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = this.getServletContext();
        String mimeType = servletContext.getMimeType("a.jpg");
        servletContext.setAttribute("msg", "hh");
        System.out.println(mimeType);
    }
}
