package ro.teamnet.zth.web;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by Eduard on 13.07.2016.
 */
public class HttpSessionZTH extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Cookie[] cookies = req.getCookies();

        if(username.equals("admin") && password.equals("admin")){
            resp.getWriter().write("Welcome back, "+username);
//            for(Cookie ck:cookies){
//                resp.getWriter().write(ck.getName()+":"+ck.getValue());
//            }

            resp.getWriter().write(req.getRequestedSessionId());
        }else{
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            session.setAttribute("session", session);
            resp.sendRedirect("views/loginFail.jsp");
        }
    }
}
