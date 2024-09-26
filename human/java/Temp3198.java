import io.undertow.Undertow;
import io.undertow.util.Headers;

public class Temp3198 {
    public static void main(String[] args) {
        Undertow server = Undertow.builder()
                .addHttpListener(8080, "localhost")
                .setHandler(exchange -> {
                    exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
                    exchange.getResponseSender().send("Hello, World!");
                }).build();
        server.start();
    }
}


To make this code executable, you will need to set up a Maven or Gradle project and include the Undertow dependency in your `pom.xml` or `build.gradle` file. Here is how you can do it with Maven:

**pom.xml:**
xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.example</groupId>
    <artifactId>temp3198</artifactId>
    <version>1.0-SNAPSHOT</version>

    <dependencies>
        <dependency>
            <groupId>io.undertow</groupId>
            <artifactId>undertow-core</artifactId>
            <version>2.0.30.Final</version>
        </dependency>
    </dependencies>
</project>


After setting up the project, you can run the `Temp3198` class to start the Undertow server.