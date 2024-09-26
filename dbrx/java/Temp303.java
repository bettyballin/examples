import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@ApplicationPath("/api")
public class Temp303 extends javax.ws.rs.core.Application {

    public static void main(String[] args) {
        // This method is not used in a typical JAX-RS application.
        // JAX-RS resources are typically deployed in a web server like Tomcat or Jetty.
    }

    @GET
    @Path("/information")
    public Response getInformation(@Context SecurityContext securityContext) {
        if (securityContext.getUserPrincipal() != null && 
            securityContext.isUserInRole("admin")) {

            // Return sensitive information for authorized users
            return Response.ok(getSensitiveInfo()).build();
        } else {
            // Return basic info for unauthorized or non-admin users
            return Response.ok(getBasicInfo()).build();
        }
    }

    private String getSensitiveInfo() {
        return "Sensitive Information";
    }

    private String getBasicInfo() {
        return "Basic Information";
    }
}



// Add the following dependencies to your pom.xml if you're using Maven:

<dependencies>
    <dependency>
        <groupId>javax.ws.rs</groupId>
        <artifactId>javax.ws.rs-api</artifactId>
        <version>2.1.1</version>
    </dependency>
    <dependency>
        <groupId>org.glassfish.jersey.containers</groupId>
        <artifactId>jersey-container-servlet-core</artifactId>
        <version>2.31</version>
    </dependency>
    <dependency>
        <groupId>org.glassfish.jersey.inject</groupId>
        <artifactId>jersey-hk2</artifactId>
        <version>2.31</version>
    </dependency>
</dependencies>