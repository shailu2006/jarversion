# Jar file compiled java version finder
Java version is a tool that identifies the version of the JDK the jar file was built in. 

# How to use the class?
The following code block shows the usage.
```java
String jarFileLocation = "\\path\\to\\jarfile\\jarchecker-0.0.1-SNAPSHOT.jar"; 
System.out.println("JDK Version used to compile is "+JarChecker.getJavaVersion(jarFileLocation));
```

Replace the jarFileLocation with the path to your file name.

Check [Wiki link](https://github.com/shailu2006/jarversion/wiki) for more details.

## TODO
* Validation to check if the file is a valid JAR, WAR, EAR and it contains an valid class file. 
* Take an folder as an input and scan the folder for JAR files and given an output which file is compiled in what version.
* Create an HTML report of the jar files parsed and thier versions. 
