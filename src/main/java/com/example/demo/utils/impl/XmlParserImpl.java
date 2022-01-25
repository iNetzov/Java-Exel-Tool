package com.example.demo.utils.impl;

import com.example.demo.utils.XmlParser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class XmlParserImpl implements XmlParser {


    @Override
    public <O> O parseXml(Class<O> objectClass, String filePath) throws JAXBException {
        return null;
    }

    @Override
    public <O> void exportXml(O object, Class<O> objectCLass, String filePath) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(objectCLass);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(object, new File(filePath));
    }
}
