package ro.teamnet.zth.web;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by Eduard on 12.07.2016.
 */
public class InfoHttpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String firstName = req.getParameter("firstName");
//        String lastName = req.getParameter("lastName");


        String method = req.getMethod();
        String query = req.getQueryString();


        Enumeration headerNames = req.getHeaderNames();
        StringBuilder headerNamesTable = new StringBuilder();
        headerNamesTable.append("<p>Method used: </p>").append(method)
                .append("<table><tr><th>Header names: </th><th>Header values: </th></tr>");
        while(headerNames.hasMoreElements()){
            String header = headerNames.nextElement().toString();
            String headerValue = req.getHeader(header);
            headerNamesTable.append("<tr><td>").append(header).append("</td>")
            .append("<td>").append(headerValue).append("</td></tr>");
        }
        headerNamesTable.append("</table>").append("<p>Query String:</p>").append(query);


        Enumeration paramNames = req.getParameterNames();
        StringBuilder paramsTable = new StringBuilder();
        paramsTable.append("<table><tr><th>Parameter names: </th><th>Parameter values: </th></tr>");
        while(paramNames.hasMoreElements()){
            String param = paramNames.nextElement().toString();
            String paramValue = req.getParameter(param);
            paramsTable.append("<tr><td>").append(param).append("</td>")
                    .append("<td>").append(paramValue).append("</td></tr>");
        }
        paramsTable.append("</table>");

//        Cookie[] cookies = req.getCookies();
//        StringBuilder cookieTable = new StringBuilder();
//        cookieTable.append("<table><tr><th>Cookies: </th></tr>");
//        for(Cookie ck:cookies){
//            cookieTable.append("<tr><td>").append(ck).append("</td></tr>");
//        }
//        cookieTable.append("</table>");

        resp.getWriter().write(headerNamesTable.append(paramsTable).toString());
    }
}
