package com.company.rpgrunner.ui.response;

/**
 * Created by Leonardo Tonin on 17/02/19.
 */
public class SimpleMessageResponse implements Response {

    private final String message;

    public SimpleMessageResponse(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
