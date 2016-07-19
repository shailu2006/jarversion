package com.jarversion;

import java.io.IOException;
import java.io.InputStream;
import java.util.jar.JarFile;

/**
 * Scan the files within the JAR, WAR, EAR and determines the version with which the jar file was build.
 * <p>
 * Created by shailesh on 7/16/2016.
 */
public class JarChecker {

    public static String getJavaVersion(String filepath) throws IOException, ClassNotFoundException {
        // TODO: Validate the file syntax

        // Get Jar file instances
        JarFile jarFile = JarProcessor.getJarFile(filepath);

        // Get Jar file class file
        InputStream classInputStream = JarProcessor.getClassInputStream(jarFile);

        // Get Hex code magic number.
        String hexCode = JarProcessor.getHexCode(classInputStream);

        // Get the Java version.
        JarVersion jarVersion = JarVersion.getJarVersion(hexCode);

        return jarVersion.getJavaVersion();
    }


}
