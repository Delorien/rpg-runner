package com.company.rpgrunner.util;

import com.company.rpgrunner.commons.exception.CriticalException;

/**
 * Created by Leonardo Tonin on 17/02/19.
 */
public class CriticalExceptionHandler {

    public static void handler(CriticalException e) {
        System.out.println(e.getMessage());
        System.exit(0);
    }
}
