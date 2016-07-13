package ro.teamnet.zth.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Eduard on 13.07.2016.
 */
public class HttpServletInclude extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher =
                req.getRequestDispatcher("/helloinclude");

        req.setAttribute("testAttribute", "Enjoy ZTH");

        requestDispatcher.include(req, resp);

        resp.getWriter().write("Adaugat dupa include !");
    }
}
