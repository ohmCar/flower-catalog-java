package com.tw.servlet;

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
    }
}
