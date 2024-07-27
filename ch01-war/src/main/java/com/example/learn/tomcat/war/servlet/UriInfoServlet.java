package com.example.learn.tomcat.war.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 配合OthersServlet一起用
 *
 * @see OthersServlet
 */
public class UriInfoServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        String title = "parameterInfo";
        Map<String, String> parameterInfo = parameterInfo(request);

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html><html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\" />");
        out.println("<title>" + title + "</title>");
        out.println("</head>");

        out.println("<body bgcolor=\"white\">");
        parameterInfo.forEach((key, Value) -> {
            out.println("<h3>" + key + "=" + Value + "</h3>");
        });
        out.println("</body>");
        out.println("</html>");
    }

    private Map<String, String> parameterInfo(HttpServletRequest request) {
        Map<String, String> info = new HashMap<>();

        // The returned URL contains a protocol, server name, port number, and server path, but it does not include query string parameters
        StringBuffer requestURL = request.getRequestURL();
        info.put("requestURL", requestURL.toString());

        // Returns the part of this request's URL from the protocol name up to the query string in the first line of the HTTP request.
        // The web container does not decode this String(如果包含中文,则返回的是percent-encoding字符串)
        String requestURI = request.getRequestURI();
        info.put("requestURI", requestURI);

        // servletPath与requestUrl是不同的,前者指向web.xml中匹配到的servlet的url-pattern;后者与http请求的first-line有关
        // This method will return an empty string ("") if the servlet used to process this request was matched using the "/*" pattern
        String servletPath = request.getServletPath();
        info.put("servletPath", servletPath);

        return info;
    }
}
