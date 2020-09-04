package com.corsface.util;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * Created by wbb on 2020/8/13.
 */

public class SimpleCORSFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("--> SimpleCORSFilter.doFilter");
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "http://192.168.1.19:8000");
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
        httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "x-requested-with");
        chain.doFilter(request, response);
    }

    public void destroy() {

    }
}
