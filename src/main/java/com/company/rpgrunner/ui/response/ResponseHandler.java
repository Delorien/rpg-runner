package com.company.rpgrunner.ui.response;

/**
 * Created by Leonardo Tonin on 17/02/19.
 */
public class ResponseHandler {

    private static ResponseHandler INSTANCE;

    private ResponseHandler() {
    }

    public static ResponseHandler getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ResponseHandler();
        }

        return INSTANCE;
    }

    public void respondToPlayer(Response response) {
        toOut(response.getMessage());
    }

    private void toOut(String response) {
        System.out.println(response);
    }
}
