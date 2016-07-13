package ro.teamnet.zth.web;

import ro.teamnet.zth.file.LogFileWriter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;


/**
 * Created by Eduard on 13.07.2016.
 */
public class HeadersLogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Enumeration headers = ((HttpServletRequest) servletRequest).getHeaderNames();
        LogFileWriter log = new LogFileWriter();
        while(headers.hasMoreElements()){
            String headerName  = headers.nextElement().toString();
            String headerValue = ((HttpServletRequest) servletRequest).getHeader(headerName.toString());
            log.logHeader(headerName, headerValue);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
