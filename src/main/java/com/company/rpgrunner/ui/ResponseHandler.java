package com.company.rpgrunner.ui;

import com.company.rpgrunner.ui.response.Response;

/**
 * Created by Leonardo Tonin on 17/02/19.
 */
public class ResponseHandler {

    public void respondToUser(Response response) {
        toOut(response.getMessage());
    }

    public void toOut(String response) {
        System.out.println(response);
    }
}
