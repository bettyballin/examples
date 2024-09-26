import org.apache.maven.shared.invoker.*;

import java.io.File;
import java.util.Collections;

public class Temp2495 {
    public static void main(String[] args) {
        compile("org.springframework.security.oauth:spring-security-oauth2:2.3.2.RELEASE");
    }

    public static void compile(String dependency) {
        InvocationRequest request = new DefaultInvocationRequest();
        request.setPomFile(new File("pom.xml"));
        request.setGoals(Collections.singletonList("dependency:get -Dartifact=" + dependency));

        Invoker invoker = new DefaultInvoker();
        invoker.setMavenHome(new File(System.getenv("MAVEN_HOME")));

        try {
            InvocationResult result = invoker.execute(request);

            if (result.getExitCode() != 0) {
                System.err.println("Build failed.");
                if (result.getExecutionException() != null) {
                    result.getExecutionException().printStackTrace();
                }
            } else {
                System.out.println("Build succeeded.");
            }
        } catch (MavenInvocationException e) {
            e.printStackTrace();
        }
    }
}


Note: Ensure you have `maven-invoker` dependency in your project to run this code. Add the following to your `pom.xml`:

xml
<dependency>
    <groupId>org.apache.maven.shared</groupId>
    <artifactId>maven-invoker</artifactId>
    <version>3.0.1</version>
</dependency>