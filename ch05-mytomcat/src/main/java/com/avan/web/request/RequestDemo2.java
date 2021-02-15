package com.avan.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName RequestDemo2
 * @Description TODO
 * @Author xinyusong
 * @Date 2021/2/9 7:35
 * @Version 1.0
 **/
@WebServlet("/requestDemo2")
public class RequestDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String agent = req.getHeader("user-agent");
        if (agent.contains("Chrome")){
        }else
            System.out.println("ie");
        String refer = req.getHeader("referer");
        System.out.println(refer);
        if(refer != null){
            if (refer.contains("mytomcat")){
                System.out.println("mytomcat");
                resp.setContentType("text/html;charset=utf-8");
                resp.getWriter().write("播放");
            }else
                System.out.println("到连接");
        }
    }
}
