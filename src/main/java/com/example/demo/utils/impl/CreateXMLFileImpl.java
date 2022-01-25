package com.example.demo.utils.impl;

import com.example.demo.utils.CreateXMLFile;

import java.io.File;
import java.io.IOException;

public class CreateXMLFileImpl implements CreateXMLFile {
    @Override
    public void createXML(String path) throws IOException {
        File myFile = new File(path);
        System.out.println("File created:"+ myFile.createNewFile());
    }
}
