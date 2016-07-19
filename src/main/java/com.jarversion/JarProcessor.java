package com.jarversion;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Formatter;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Created by shailesh on 7/16/2016.
 */
public class JarProcessor {
    public static String getHexCode(InputStream classInputStream) throws IOException {
        Formatter formatter = new Formatter();
        int count = 0;
        while (classInputStream.available() > 0) {
            if (count == 7) {
                return formatter.format("%02X", classInputStream.read()).toString();
            }
            classInputStream.read();
            count++;
        }

        return "";
    }

    public static InputStream getClassInputStream(JarFile jarFile) throws IOException, ClassNotFoundException {
        Enumeration<JarEntry> jarEntries = jarFile.entries();

        while (jarEntries.hasMoreElements()) {
            //Check if the current Jar entry is a class file.
            JarEntry jarEntry = jarEntries.nextElement();
            if (jarEntry.getName().contains(".class")) {
                return jarFile.getInputStream(jarEntry);
            }
        }
        throw new ClassNotFoundException("No Class file found in jar.");
    }

    public static JarFile getJarFile(String filepath) throws IOException, SecurityException {
        return new JarFile(filepath);
    }
}
