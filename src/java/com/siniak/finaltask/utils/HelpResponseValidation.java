package com.siniak.finaltask.utils;

import com.siniak.finaltask.entity.HelpResponse;

public class HelpResponseValidation {
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
