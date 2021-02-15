package com.avan.web.mytomcat;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @ClassName MyServlet
 * @Description TODO
 * @Author xinyusong
 * @Date 2021/2/8 14:32
 * @Version 1.0
 **/
@WebServlet(urlPatterns = "/demo")
public class MyServlet implements Servlet {
    public void init(ServletConfig config) throws ServletException {

    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
