package com.siniak.finaltask.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

public class SessionRequestContent {
    private Map<String, Object> requestAttributes = new HashMap<>();
    private Map<String, String[]> requestParameters = new HashMap<>();
    private Map<String, Object> sessionAttributes = new HashMap<>();
    private List<String> deletedSessionAttributes = new ArrayList<>();

    public SessionRequestContent() {
    }

    public void insertValues(HttpServletRequest request) {
        insertRequestAttributes(request);
        insertSessionAttributes(request);
    }

    public void extractValues(HttpServletRequest request) {
        requestParameters = request.getParameterMap();
        extractRequestAttributes(request);
        extractSessionAttributes(request);
    }

    public String getParameter(String parameterName) {
        if (requestParameters.get(parameterName) != null) {
            return requestParameters.get(parameterName)[0];
        }
        return null;
    }

    public Object getSessionAttribute(String attribute) {
        return sessionAttributes.get(attribute);
    }

    public String[] getAllParameters(String parameterName) {
        return requestParameters.get(parameterName);
    }

    public void setRequestAttribute(String attributeName, Object attributeValue) {
        requestAttributes.put(attributeName, attributeValue);
    }

    public void setSessionAttribute(String attributeName, Object attributeValue) {
        sessionAttributes.put(attributeName, attributeValue);
    }

    public void removeRequestAttribute(String attribute) {
        requestAttributes.remove(attribute);
    }

    public void removeSessionAttribute(String attribute) {
        deletedSessionAttributes.add(attribute);
    }

    private void extractRequestAttributes(HttpServletRequest request) {
        Enumeration attributeNames = request.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String name = (String) attributeNames.nextElement();
            Object value = request.getAttribute(name);
            requestAttributes.put(name, value);
        }
    }

    private void extractSessionAttributes(HttpServletRequest request) {
        Enumeration attributeNames = request.getSession().getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String name = (String) attributeNames.nextElement();
            Object value = request.getSession().getAttribute(name);
            sessionAttributes.put(name, value);
        }
    }

    private void insertRequestAttributes(HttpServletRequest request) {
        if (requestAttributes.isEmpty()) {
            return;
        }
        for (Map.Entry<String, Object> requestAttribute : requestAttributes.entrySet()) {
            request.setAttribute(requestAttribute.getKey(), requestAttribute.getValue());
        }
    }

    private void insertSessionAttributes(HttpServletRequest request) {
        if (sessionAttributes.isEmpty()) {
            return;
        }
        for (Map.Entry<String, Object> sessionAttribute : sessionAttributes.entrySet()) {
            request.getSession().setAttribute(sessionAttribute.getKey(), sessionAttribute.getValue());
        }
        if(!deletedSessionAttributes.isEmpty()){
            for (String attribute : deletedSessionAttributes) {
                request.getSession().removeAttribute(attribute);
            }
            deletedSessionAttributes.clear();
        }
    }
}

