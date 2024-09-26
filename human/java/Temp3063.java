// Save this as Temp3063.java
public class Temp3063 {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}


xml
<!-- Save this as pom.xml -->
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.example</groupId>
    <artifactId>temp3063</artifactId>
    <version>1.0-SNAPSHOT</version>

    <dependencies>
        <dependency>
            <groupId>com.spotify</groupId>
            <artifactId>completable-futures</artifactId>
            <version>0.3.3</version>
        </dependency>
    </dependencies>

</project>


sh
# To compile and run the Java code with Maven, execute the following commands in your terminal:
# First, navigate to the directory containing the pom.xml and Temp3063.java files.

# Compile the project
mvn compile

# Run the Java code
mvn exec:java -Dexec.mainClass="Temp3063"