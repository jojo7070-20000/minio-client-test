package org.jojo7070;

import org.jojo7070.cmd.FileUploader;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws XmlPullParserException, NoSuchAlgorithmException, InvalidKeyException, IOException {
        System.out.println("Hello World!");

        FileUploader.run();
    }
}
