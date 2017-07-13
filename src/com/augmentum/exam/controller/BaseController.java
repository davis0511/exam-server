package com.augmentum.exam.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.augmentum.exam.AppContext;
import com.augmentum.exam.Constants;
import com.augmentum.exam.model.User;
import com.augmentum.exam.util.PathUtil;
import com.augmentum.exam.util.SessionUtil;

public abstract class BaseController {

    private final Logger logger = Logger.getLogger(BaseController.class);

    @ExceptionHandler
    public ModelAndView handlerException(Exception e) {
        logger.error(e.getMessage(), e);
        ModelAndView modelAndView = new ModelAndView(AppContext.getContextPath() + Constants.SERVICE_ERROR);
        return modelAndView;
    }
    protected User getUser() {
        return AppContext.getAppContext().getUser();
    }

    public String getUserName() {
        User user = getUser();
        if (user != null) {
            return user.getUserName();
        } else {
            return "";
        }
    }

    public int getUserId() {
        User user = getUser();
        if (user != null) {
            return user.getId();
        } else {
            return 0;
        }
    }
    protected RedirectView getRedirectView(String path) {

        return new RedirectView(PathUtil.getFullPath(path));
    }
    protected void addSession(String key, Object object) {
        SessionUtil.addSession(key, object);
    }
    protected void getSession(String key) {
        SessionUtil.getSession(key);
    }
    protected void removeSession(String key) {
        SessionUtil.removeSession(key);
    }
    protected void invalidate() {
        SessionUtil.invalidate();
    }
}
