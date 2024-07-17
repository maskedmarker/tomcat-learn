package com.example.learn.tomcat.war;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ResourceBundle;

public class HelloWorld extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        demoPath(request);
        String title = getTitle(request);

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html><html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\" />");
        out.println("<title>" + title + "</title>");
        out.println("</head>");
        out.println("<body bgcolor=\"white\">");
        out.println("<h1>" + title + "</h1>");
        out.println("</body>");
        out.println("</html>");
    }

    private String getTitle(HttpServletRequest request) {
        URL bundle = this.getClass().getClassLoader().getResource("bundle");
        System.out.println("bundle.getPath() = " + bundle.getPath());

        URL[] urls = {bundle};
        ResourceBundle rb = ResourceBundle.getBundle("LocalStrings", request.getLocale(), new URLClassLoader(urls));
        String title = rb.getString("helloworld.title");

        return title;
    }

    private void demoPath(HttpServletRequest request) {
        File cwd = new File("");
        System.out.println("cwd.getAbsolutePath() = " + cwd.getAbsolutePath());
        File file = new File(cwd.getParent(), "/WEB-INF/classes/bundle");
        System.out.println("file.getAbsolutePath() = " + file.getAbsolutePath());

        String servletPathRealPath = request.getServletContext().getRealPath(request.getServletPath());
        System.out.println("servletPathRealPath = " + servletPathRealPath);
    }
}
