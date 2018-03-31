package com.tw.servlet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String filePath = "/Users/omkarm/IdeaProjects/flower-catalog-java/src/main/webapp/Login.jsp";
        List<String> content = Files.readAllLines(Paths.get(filePath));
        String loginPage = String.join(" ", content);
        res.getWriter().write(loginPage);
        res.getWriter().write(getLoginPage(""));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String username = req.getParameterValues("username")[0];
        String password = req.getParameterValues("password")[0];
        if(!(username.equals("omkar") && password.equals("omkar"))){
            res.getWriter().write(getLoginPage("Wrong username or password!<br>"));
            return;
        }
        Cookie nameCookie = new Cookie("username",username);
        Cookie passwordCookie = new Cookie("password",password);
        res.addCookie(nameCookie);
        res.addCookie(passwordCookie);
        res.setStatus(res.SC_MOVED_TEMPORARILY);
        res.setHeader("Location", "/flower-catalog/guestbook");
    }

    private String getLoginPage(String message) throws IOException {
        String pwd = System.getProperty("user.dir");
        String filePath = pwd + "/src/main/webapp/Login.jsp";
        List<String> content = Files.readAllLines(Paths.get(filePath));
        String loginPage = String.join(" ", content);
        loginPage = loginPage.replace("{{ message }}", message);
        return loginPage;
    }
}
