package com.tw.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GuestBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        if(req.getCookies()!=null){
            res.getWriter().write("<html>hello how are you</html>");
        }

        res.getWriter().write("<a href=/flower-catalog/login> Login to comment</a>");
    }
}
