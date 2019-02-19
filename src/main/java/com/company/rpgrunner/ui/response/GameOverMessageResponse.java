package com.company.rpgrunner.ui.response;

import com.company.rpgrunner.commons.GameMessage;

import static com.company.rpgrunner.commons.GameMessage.YOU_LOOSE;

/**
 * Created by Leonardo Tonin on 17/02/19.
 */
public class GameOverMessageResponse implements Response {

    @Override
    public String getMessage() {
        return GameMessage.getMessage(YOU_LOOSE);
    }
}
