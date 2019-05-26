package com.siniak.finaltask.controller;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

public class SessionRequestContent {
    private Map<String, Object> requestAttributes = new HashMap<>();
    private Map<String, String[]> requestParameters = new HashMap<>();
    private Map<String, Object> sessionAttributes = new HashMap<>();
    private List<String> deletedSessionAttributes = new ArrayList<>();
    private Collection<Part> parts;
    private String contextPath;

    static final Logger logger = LogManager.getLogger();


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
        try {
           parts = request.getParts();
        } catch (IOException|ServletException|IllegalStateException e) {
           logger.log(Level.INFO, e);
        }
        extractContextPath(request);
    }

    public String getParameter(String parameterName) {
        if (requestParameters.get(parameterName) != null) {
            return stripXSS(requestParameters.get(parameterName)[0]);
        }
        return null;
    }

    public Object getSessionAttribute(String attribute) {
        return sessionAttributes.get(attribute);
    }

    public String[] getAllParameters(String parameterName) {
        int size = requestParameters.get(parameterName).length;
        String[] escapedParameters = new String[size];
        for (int i = 0; i < size; i++) {
            escapedParameters[i] = stripXSS(requestParameters.get(parameterName)[i]);
        }
        return escapedParameters;
    }

    public void setRequestAttribute(String attributeName, Object attributeValue) {
        attributeName = stripXSS(attributeName);
        requestAttributes.put(attributeName, attributeValue);
    }

    public void setSessionAttribute(String attributeName, Object attributeValue) {
        attributeName = stripXSS(attributeName);
        sessionAttributes.put(attributeName, attributeValue);
    }

    public void removeRequestAttribute(String attribute) {
        requestAttributes.remove(attribute);
    }

    public void removeSessionAttribute(String attribute) {
        deletedSessionAttributes.add(attribute);
    }

    public Collection<Part> getParts() {
        return parts;
    }

    public String getContextPath() {
        return contextPath;
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

    private void extractContextPath(HttpServletRequest request) {
        contextPath = request.getServletContext().getRealPath("");
    }

    private String stripXSS(String value) {
        if (value != null) {
            value = value.replaceAll("", "");

            // Avoid anything between script tags
            Pattern scriptPattern = Pattern.compile("<script>(.*?)</script>", Pattern.CASE_INSENSITIVE);
            value = scriptPattern.matcher(value).replaceAll("");

            // Avoid anything in a src='...' type of expression
            scriptPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            value = scriptPattern.matcher(value).replaceAll("");

            scriptPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\\"(.*?)\\\"", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            value = scriptPattern.matcher(value).replaceAll("");

            // Remove any lonesome </script> tag
            scriptPattern = Pattern.compile("</script>", Pattern.CASE_INSENSITIVE);
            value = scriptPattern.matcher(value).replaceAll("");

            // Remove any lonesome <script ...> tag
            scriptPattern = Pattern.compile("<script(.*?)>", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            value = scriptPattern.matcher(value).replaceAll("");

            // Avoid eval(...) expressions
            scriptPattern = Pattern.compile("eval\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            value = scriptPattern.matcher(value).replaceAll("");

            // Avoid expression(...) expressions
            scriptPattern = Pattern.compile("expression\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            value = scriptPattern.matcher(value).replaceAll("");

            // Avoid javascript:... expressions
            scriptPattern = Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE);
            value = scriptPattern.matcher(value).replaceAll("");

            // Avoid vbscript:... expressions
            scriptPattern = Pattern.compile("vbscript:", Pattern.CASE_INSENSITIVE);
            value = scriptPattern.matcher(value).replaceAll("");

            // Avoid onload= expressions
            scriptPattern = Pattern.compile("onload(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
            value = scriptPattern.matcher(value).replaceAll("");
        }
        return value;
    }
}

