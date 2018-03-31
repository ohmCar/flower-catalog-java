package com.tw.servlet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class GuestBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String filePath = "/Users/omkarm/IdeaProjects/flower-catalog-java/src/main/webapp/GuestBook.jsp";
        List<String> content = Files.readAllLines(Paths.get(filePath));
        String guestBookPage = String.join(" ", content);
        res.getWriter().write(guestBookPage);
        if(!hasCookie(req)){
            res.getWriter().write(getGuestBook());
            return;
        }
        res.getWriter().write(getGuestBookWhenLoggedIn());
    }

    private String getGuestBook() throws IOException {
        String pwd = System.getProperty("user.dir");
        String filePath = pwd + "/src/main/webapp/GuestBook.jsp";
        List<String> content = Files.readAllLines(Paths.get(filePath));
        String guestBookPage = String.join(" ", content);
        return guestBookPage;
    }

    private String getGuestBookWhenLoggedIn() throws IOException {
        String pwd = System.getProperty("user.dir");
        String filePath = pwd + "/src/main/webapp/GuestBookComment.jsp";
        List<String> content = Files.readAllLines(Paths.get(filePath));
        String guestBookPage = String.join(" ", content);
        return guestBookPage;
    }

    private boolean hasCookie(HttpServletRequest req){
        Cookie[] cookies = req.getCookies();
        if(cookies!=null){
            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("username")){
                    return true;
                }
            }
        }
        return false;
    }
}
