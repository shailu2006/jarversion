package com.jarversion;

/**
 * Created by shailesh on 7/16/2016.
 */
public enum JarVersion {
    JDK11("JDK 1.1", "2D"), JDK12("JDK 1.2", "2E"), JDK13("JDK 1.2", "2F"), JDK14("JDK 1.4", "30"),
    JDK15("JDK 1.5", "31"), JDK16("JDK 1.6", "32"), JDK17("JDK 1.7", "33"), JDK18("JDK 1.8", "34"),
    JDK19("JDK 1.9", "35"), INVALID("Invalid JDK", "");

    private String hex = "0";
    private String javaVersion = "";

    JarVersion(String javaVersion, String hex) {
        this.javaVersion = javaVersion;
        this.hex = hex;
    }

    /**
     * Get the Jar Version based on hex input.
     *
     * @param hexInput valid hex in the input stream
     * @return JarVersion
     */
    public static JarVersion getJarVersion(final String hexInput) {
        for (JarVersion jarVersion : JarVersion.values()) {
            if (hexInput.equals(jarVersion.getHex())) {
                return jarVersion;
            }
        }
        return INVALID;
    }

    public String getHex() {
        return hex;
    }

    public String getJavaVersion() {
        return javaVersion;
    }
}
