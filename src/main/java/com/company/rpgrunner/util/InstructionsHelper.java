package com.company.rpgrunner.util;

import com.company.rpgrunner.ui.response.SimpleMessageResponse;

import static com.company.rpgrunner.commons.GameMessage.INSTRUCTIONS_MESSAGE;
import static com.company.rpgrunner.commons.GameMessage.getMessage;

/**
 * Created by Leonardo Tonin on 17/02/19.
 */
public class InstructionsHelper {

    public SimpleMessageResponse getInstructions() {
        return new SimpleMessageResponse(getMessage(INSTRUCTIONS_MESSAGE));
    }
}
