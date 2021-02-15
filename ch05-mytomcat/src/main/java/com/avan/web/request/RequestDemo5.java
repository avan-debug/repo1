package com.avan.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName RequestDemo3
 * @Description TODO
 * @Author xinyusong
 * @Date 2021/2/9 8:23
 * @Version 1.0
 **/
@WebServlet("/requestDemo5")
public class RequestDemo5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("demo5================");
        /*转发需要设置同一个虚拟目录*/
        /*req.setAttribute("name", "hello");
        req.getRequestDispatcher("/requestDemo6").forward(req, resp);*/

        /*resp.setStatus(302);
        resp.setHeader("location", "/mytomcat/requestDemo6");*/
        String contextPath = req.getContextPath();

        resp.sendRedirect(contextPath + "/requestDemo6");
    }
}
