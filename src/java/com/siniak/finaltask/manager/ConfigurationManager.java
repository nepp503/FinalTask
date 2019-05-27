package com.siniak.finaltask.manager;

import java.util.ResourceBundle;

/**
 * Manager for config properties
 * @author Vitali Siniak
 */

public class ConfigurationManager {
    private final static ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("config");

    private ConfigurationManager() {
    }

    public static String getProperty(String key) {
        return RESOURCE_BUNDLE.getString(key);
    }
}
