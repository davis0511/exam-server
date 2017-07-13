package com.augmentum.exam.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.augmentum.exam.Constants;

public final class AppPropertyUtil {
    private static Properties properties = null;

    static {
        InputStream appInput = null;
        try {
            appInput = AppPropertyUtil.class.getClassLoader().getResourceAsStream(Constants.APP_PROPERTY);
            properties = new Properties();
            properties.load(appInput);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (appInput != null) {
                try {
                    appInput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String getAppProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getStaticUrl() {
        return properties.getProperty("static_url");
    }
}
