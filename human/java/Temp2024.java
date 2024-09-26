import org.springframework.web.client.RestTemplate;

public class SpringRestClient {

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://example.com/api";

        // Replace with your actual request and response handling
        String response = restTemplate.getForObject(url, String.class);
        System.out.println(response);
    }
}


xml
<!-- pom.xml -->
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.websystique.springmvc</groupId>
    <artifactId>SpringRestClient</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>1.8</maven.compiler.source>
        <maven.compiler.target>1.8</maven.compiler.target>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-web</artifactId>
            <version>5.3.22</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.8.1</version>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.codehaus.mojo</groupId>
                <artifactId>exec-maven-plugin</artifactId>
                <version>3.0.0</version>
                <executions>
                    <execution>
                        <goals>
                            <goal>java</goal>
                        </goals>
                    </execution>
                </executions>
                <configuration>
                    <mainClass>com.websystique.springmvc.SpringRestClient</mainClass>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>


Run with:
sh
mvn clean compile exec:java -Dexec.mainClass="com.websystique.springmvc.SpringRestClient"