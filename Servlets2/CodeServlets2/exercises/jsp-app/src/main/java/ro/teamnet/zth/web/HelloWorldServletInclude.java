package ro.teamnet.zth.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Eduard on 13.07.2016.
 */
public class HelloWorldServletInclude extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String attribute = (String)req.getAttribute("testAttribute");
        resp.getWriter().write("Hello <b>"+req.getParameter("user")+"</b> from the Forward Servlet " + attribute);

    }
}
