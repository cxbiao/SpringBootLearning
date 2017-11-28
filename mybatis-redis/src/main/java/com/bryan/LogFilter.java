package com.bryan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@WebFilter("/api/*")
public class LogFilter implements Filter{

    private Logger logger= LoggerFactory.getLogger(LogFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletResponse httpServletResponse=(HttpServletResponse)servletResponse;
        HttpServletRequest httpServletRequest=(HttpServletRequest)servletRequest;

        MyWrapResponse wrapResponse=new MyWrapResponse(httpServletResponse);
        filterChain.doFilter(servletRequest,wrapResponse);

        byte[] src = wrapResponse.getSrc();
        //输出
        OutputStream out = servletResponse.getOutputStream();
        out.write(src);
        logger.info(new String(src,"UTF-8"));
    }

    @Override
    public void destroy() {

    }
}
