package com.avan.web.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName CookieDemo4
 * @Description TODO
 * @Author xinyusong
 * @Date 2021/2/11 7:59
 * @Version 1.0
 **/
@WebServlet("/cookieDemo4")
public class CookieDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        boolean has = false;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        String format = dateFormat.format(new Date());
        String encode = URLEncoder.encode(format, "utf-8");
        Cookie newCookie = new Cookie("hasCome", encode);
        newCookie.setMaxAge(60*60*24);
        if (cookies != null){
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("hasCome")){
                    resp.setContentType("text/html;charset=utf-8");

                    String date = cookie.getValue();
                    String decode = URLDecoder.decode(date, "utf-8");
                    resp.getWriter().println("你好，您上次的访问时间为" + decode);
                    resp.addCookie(newCookie);
                    has = true;
                }
            }
        }
        if(!has){
            System.out.println(format);
            resp.addCookie(newCookie);
            resp.setContentType("text/html;charset=utf-8");
            resp.getWriter().println("你好，欢迎首次访问");
        }
    }
}
