package com.company.rpgrunner.util;

import com.company.rpgrunner.commons.exception.ErrorOnTryLoadASCIIPicture;

import java.nio.file.Files;
import java.nio.file.Paths;

import static com.company.rpgrunner.commons.GameResourcesPath.ASCII_PICS_PATH;

/**
 * Created by lneto on 19/02/19.
 */
public class ASCIIPictureHelper {

    private static ASCIIPictureHelper INSTANCE;

    private ASCIIPictureHelper() {
    }

    public static ASCIIPictureHelper getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ASCIIPictureHelper();
        }
        return INSTANCE;
    }

    public String loadPicture(String name) throws ErrorOnTryLoadASCIIPicture {
        try {
            return new String(Files.readAllBytes(Paths.get(ClassLoader.getSystemResource(ASCII_PICS_PATH + "/" + name).toURI())));
        } catch (Exception e) {
            throw new ErrorOnTryLoadASCIIPicture();
        }
    }
}
