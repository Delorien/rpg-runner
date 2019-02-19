package com.company.rpgrunner.ui.response;

import com.company.rpgrunner.commons.PicturePrintable;
import com.company.rpgrunner.commons.exception.ErrorOnTryLoadASCIIPicture;
import com.company.rpgrunner.util.ASCIIPictureHelper;

import java.util.Optional;

/**
 * Created by Leonardo Tonin on 17/02/19.
 */
public class PicturePrintableResponse implements Response {

    public static final String JUMP_LINE = "\n";

    private final PicturePrintable picturePrintable;
    private final String message;

    public PicturePrintableResponse(PicturePrintable picturePrintable, String message) {
        this.picturePrintable = picturePrintable;
        this.message = message;
    }

    @Override
    public String getMessage() {

        Optional<String> picture = loadPicture();

        StringBuilder stringBuilder = new StringBuilder();

        if (picture.isPresent()) {
            stringBuilder.append(picture.get());
            stringBuilder.append(JUMP_LINE);
        }
        stringBuilder.append(message);

        return stringBuilder.toString();
    }

    private Optional<String> loadPicture() {
        try {
            return Optional.of(ASCIIPictureHelper.getInstance().loadPicture(picturePrintable.getPictureName()));
        } catch (ErrorOnTryLoadASCIIPicture errorOnTryLoadASCIIPicture) {
            return Optional.empty();
        }
    }
}
