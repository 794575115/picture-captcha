package com.example.picturecaptcha;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Shiimin
 * @date 2020/11/24
 */
@WebServlet(urlPatterns = "/wendao/regist.do")
public class Servlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String verifyCode = req.getParameter("verifyCode");
        HttpSession session = req.getSession();

    }
}
