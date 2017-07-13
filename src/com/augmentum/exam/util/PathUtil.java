package com.augmentum.exam.util;

import com.augmentum.exam.AppContext;
import com.augmentum.exam.Constants;

public class PathUtil {

    public static String getFullPath(String path) {
        if (path == null) {
            path = "";
        }
        String urlPrefix = Constants.APP_URL_PREFIX;
        if (!StringUtil.isEmpty(urlPrefix)) {
            urlPrefix += "/";
        }
        return AppContext.getContextPath() + "/" + urlPrefix + path;
    }
}
