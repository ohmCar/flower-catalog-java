package com.tw.servlet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String str = "<html><form method=POST>" +
                "<input type=text name=username required/>" +
                "<input type=submit>" +
                "</form></html>";
        res.getWriter().write(str);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String username = req.getParameterValues("username")[0];
        Cookie cookie = new Cookie("username",username);
        res.addCookie(cookie);
        res.setStatus(res.SC_MOVED_TEMPORARILY);
        res.setHeader("Location", "/flower-catalog/guestbook");
    }
}
