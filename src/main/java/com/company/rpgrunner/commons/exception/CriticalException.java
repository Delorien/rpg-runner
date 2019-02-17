package com.company.rpgrunner.commons.exception;

/**
 * Created by Leonardo Tonin on 17/02/19.
 */
public abstract class CriticalException extends Exception {

    CriticalException(String message) {
        super(message);
    }
}
