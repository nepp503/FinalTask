package com.siniak.finaltask.command;

import static com.siniak.finaltask.constant.Constant.INDEX_PAGE;

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
