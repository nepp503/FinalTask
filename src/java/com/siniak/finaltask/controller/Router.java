package com.siniak.finaltask.controller;

import static com.siniak.finaltask.utils.AttributeParameterPathConstant.INDEX_PAGE;

public class Router {
    public enum PathType {
        FORWARD, REDIRECT
    }

    private String page = INDEX_PAGE;

    private PathType pathType = PathType.FORWARD;

    public String getPage() {
        return page;
    }

    public PathType getPathType() {
        return pathType;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public void setRedirect() {
        this.pathType = PathType.REDIRECT;
    }
}
