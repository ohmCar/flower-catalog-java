package com.tw.servlet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)  {
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            cookie.setMaxAge(0);
            res.addCookie(cookie);
        }
        res.setStatus(res.SC_MOVED_TEMPORARILY);
        res.setHeader("Location", "/flower-catalog/guestbook");
    }
}
