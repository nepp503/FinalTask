package com.siniak.finaltask.manager;

import java.util.ResourceBundle;

/**
 * Manager for message properties
 * @author Vitali Siniak
 */

public class MessageManager {
    private final static ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("message");

    private MessageManager() {
    }

    public static String getProperty(String key) {
        return RESOURCE_BUNDLE.getString(key);
    }
}
