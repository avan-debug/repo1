package com.avan.web.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName CookieDemo1
 * @Description TODO
 * @Author xinyusong
 * @Date 2021/2/11 6:55
 * @Version 1.0
 **/
@WebServlet("/cookieDemo1")
public class CookieDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("name", "hello");
        /*
        * 正数：表示持久化硬盘存储，存储时间为设置的参数值
        * 负数：默认存储在浏览器内存
        * 0：表示删除cookie
        * */
        cookie.setMaxAge(100);
        /*
        * cookie默认访问范围是当前虚拟目录下
        * setpath方法可以设置访问范围 /为当前所有项目（同一tomcat服务器下）
        * setDomain方法设置cookie共享域名
        * 如www.baidu.com 若设置参数为".baidu.com则cookie在百度域名下共享
        * */
        Cookie cookie1 = new Cookie("name1", "hello1");
        resp.addCookie(cookie);
        resp.addCookie(cookie1);
    }
}
