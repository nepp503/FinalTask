package com.siniak.finaltask.util;

import com.siniak.finaltask.entity.HelpResponse;

/**
 * Validation of help response
 * @author Vitali Siniak
 */

public class HelpResponseValidation {

    /**
     * Checks if help response valid or not
     * @param response
     * @see HelpResponse
     * @return true, if help response is valid, false - otherwise
     */
    public boolean isValid(HelpResponse response) {
        return isTitleValid(response.getTitle()) && isBodyValid(response.getBody());
    }

    private boolean isTitleValid(String title) {
        if (title != null && !title.isEmpty() && title.length() < 100) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isBodyValid(String body) {
        if (body != null && !body.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
