package com.siniak.finaltask.controller;

import static com.siniak.finaltask.util.AttributeParameterPathConstant.INDEX_PAGE;

/**
 * Describes the path and type of transfer to next source
 * @author Vitali Siniak
 */

public class Router {
    /**
     * Describes two types of transfer
     */
    public enum PathType {
        FORWARD, REDIRECT
    }

    private String page = INDEX_PAGE;

    private PathType pathType = PathType.FORWARD;

    /**
     * Returns path to the next source
     * @return page
     */
    public String getPage() {
        return page;
    }

    /**
     * Returns type of transfer to the next source
     * @return
     * @see PathType
     */
    public PathType getPathType() {
        return pathType;
    }

    /**
     * Sets the path to the next source
     * @param page
     */
    public void setPage(String page) {
        this.page = page;
    }

    /**
     * Returns type of transfer to the next source as redirect
     */
    public void setRedirect() {
        this.pathType = PathType.REDIRECT;
    }
}
