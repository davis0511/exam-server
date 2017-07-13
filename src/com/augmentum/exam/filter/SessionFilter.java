package com.augmentum.exam.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.augmentum.exam.Constants;
import com.augmentum.exam.model.User;
import com.augmentum.exam.util.PathUtil;

public class SessionFilter implements Filter {

    private static final String NOTNEEDLOGINPAGES = "notNeedLoginPages";
    private String notNeedLoginPages = null;
    protected FilterConfig filterConfig;

    @Override
    public void destroy() {
        this.notNeedLoginPages = null;
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
            FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        String uri = request.getRequestURI();
        String requestedUri = uri.substring(request.getContextPath().length() + 1);

        String [] pages = notNeedLoginPages.split(Constants.COMMA);
        boolean isAllow = false;
        for (String page : pages) {
            if (page.equals(requestedUri)) {
                isAllow = true;
                break;
            }
        }
        if (isAllow) {
            filterChain.doFilter(request, response);
        } else {
            HttpSession session = request.getSession();
            User user = (User)session.getAttribute(Constants.USER);
            if (user == null) {
                response.sendRedirect(PathUtil.getFullPath(Constants.LOGIN_ACTION));
            } else {
                filterChain.doFilter(request, response);
            }
        }
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        if (filterConfig.getInitParameter(NOTNEEDLOGINPAGES) != null) {
            notNeedLoginPages = filterConfig.getInitParameter(NOTNEEDLOGINPAGES);
        }
    }
}
