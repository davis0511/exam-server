package com.augmentum.exam.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.augmentum.exam.AppContext;
import com.augmentum.exam.Constants;
import com.augmentum.exam.model.User;

 public class AppContextFilter extends javax.servlet.http.HttpServlet implements javax.servlet.Filter {
    private static final long serialVersionUID = 1L;

    public AppContextFilter() {
        super();
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
            FilterChain filterChain) throws IOException, ServletException {
        // Through the filter, get request and response.
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        AppContext.setContextPath(request.getContextPath());
        AppContext appContext  = AppContext.getAppContext();
        HttpSession session = request.getSession();

        User user = (User)session.getAttribute(Constants.USER);
        appContext.addObject(Constants.APP_CONTEXT_USER, user);
        appContext.addObject(Constants.APP_CONTEXT_SESSION, session);
        try {
            filterChain.doFilter(request, response);
        } catch(IOException ex) {
           throw ex;
        } catch(ServletException servletException) {
           throw servletException;
        } catch(RuntimeException runtimeException) {
           throw runtimeException;
        } finally {
            appContext.clear();
        }
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
}