package com.avan.web.mytomcat;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @ClassName MyServlet2
 * @Description TODO
 * @Author xinyusong
 * @Date 2021/2/8 15:01
 * @Version 1.0
 **/
@WebServlet("/demo2")
public class MyServlet2 extends GenericServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("myservlet2---------");
    }
}
