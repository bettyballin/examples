// You need to set up a Maven project to use dependencies. Here is a complete executable Java program with a Maven setup.

pom.xml:
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.example</groupId>
    <artifactId>Temp3676</artifactId>
    <version>1.0-SNAPSHOT</version>
    <dependencies>
        <dependency>
            <groupId>com.auth0</groupId>
            <artifactId>java-jwt</artifactId>
            <version>4.0.0</version>
        </dependency>
    </dependencies>
</project>

src/main/java/com/example/Temp3676.java:
package com.example;

public class Temp3676 {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}


To execute this, you need to:
1. Create a Maven project directory structure.
2. Place the `pom.xml` file in the root of the project.
3. Place the `Temp3676.java` file in the `src/main/java/com/example/` directory.
4. Run `mvn compile` to compile the project.
5. Run `mvn exec:java -Dexec.mainClass="com.example.Temp3676"` to execute the program.