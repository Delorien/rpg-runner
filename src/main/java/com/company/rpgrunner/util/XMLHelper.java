package com.company.rpgrunner.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by Leonardo Tonin on 16/02/19.
 */
public class XMLHelper {

    public <T> T unmarshal(String fileName, Class<T> type) throws JAXBException {

        final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        final File file = new File(classLoader.getResource(fileName).getFile());

        final JAXBContext context = JAXBContext.newInstance(type);
        final Unmarshaller unmarshaller = context.createUnmarshaller();
        return (T) unmarshaller.unmarshal(file);
    }
}
