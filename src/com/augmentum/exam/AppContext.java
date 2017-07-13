package com.augmentum.exam;

import java.util.HashMap;
import java.util.Map;

import com.augmentum.exam.model.User;

public class AppContext {

    private static ThreadLocal<AppContext> appContextMap = new ThreadLocal<AppContext>();

    private Map<String, Object> objects = new HashMap<String, Object>();
    private static String contextPath;

    private AppContext() {

    }

    public static String getContextPath() {
        return contextPath;
    }
    public static void setContextPath(String contextPath) {
        if (AppContext.contextPath == null) {
            AppContext.contextPath = contextPath;
        }
    }

    public static AppContext getAppContext() {
        AppContext appContext = appContextMap.get();
        if (appContext == null) {
            appContext = new AppContext();
            appContextMap.set(appContext);
        }
        return appContextMap.get();
    }

    public Map<String, Object> getObjects() {
        return objects;
    }

    public void setObjects(Map<String, Object> objects) {
       if (objects == null) {
           objects = new HashMap<String, Object>();
       }
        this.objects = objects;
    }

    public void addObject(String key, Object object) {
        this.objects.put(key, object);
    }

    public Object getObject(String key) {
        return objects.get(key);
    }

    public void clear() {
        objects.clear();
    }

    public void removeObject(String key) {
        objects.remove(key);
    }

    public User getUser() {
        return (User)objects.get(Constants.APP_CONTEXT_USER);
    }

    public String getUserName() {
        User user = (User)objects.get(Constants.APP_CONTEXT_USER);
        if (user != null) {
            return user.getUserName();
        } else {
            return "";
        }
    }

    public int getUserId() {
        User user = (User)objects.get(Constants.APP_CONTEXT_USER);
        if (user != null) {
            return user.getId();
        } else {
            return 0;
        }
    }
}
