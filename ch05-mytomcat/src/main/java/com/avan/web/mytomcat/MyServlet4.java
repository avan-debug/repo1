package com.avan.web.mytomcat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName MyServlet4
 * @Description TODO
 * @Author xinyusong
 * @Date 2021/2/8 15:40
 * @Version 1.0
 **/
@WebServlet(urlPatterns = {"/demo4", "/demo4/*"})
public class MyServlet4 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doget=============");
        System.out.println(req);
    }
}
