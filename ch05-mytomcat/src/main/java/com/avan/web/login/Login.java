package com.avan.web.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName Login
 * @Description TODO
 * @Author xinyusong
 * @Date 2021/2/11 11:36
 * @Version 1.0
 **/
@WebServlet("/loginVerify")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String verifyAutoCode = (String) session.getAttribute("verifyCode");
        session.removeAttribute("verifyCode");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String verifyCode = req.getParameter("verifyCode");
        if (verifyCode != null && verifyCode.equalsIgnoreCase(verifyAutoCode)){
            if("avan".equals(username) && "123".equals(password)){
                resp.sendRedirect("/mytomcat/htmls/location.html");
            }else {
                req.setAttribute("cc_error", "密码错误");
                req.getRequestDispatcher("/htmls/login.jsp").forward(req, resp);
            }
        }else {
            req.setAttribute("cc_error", "验证码错误");
            req.getRequestDispatcher("/htmls/login.jsp").forward(req, resp);

        }
    }
}
