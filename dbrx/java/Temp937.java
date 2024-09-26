import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.RouteDefinition;

public class Temp937 {
    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();

        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() {
                from("direct:start")
                    // .policy("admin") // Uncomment this line if you have a valid security policy
                    .to("mock:result");
            }
        });

        context.start();
        Thread.sleep(5000);
        context.stop();
    }
}
 

Note: The above code doesn't have any syntax errors. However, to compile it, you need to have camel-core and camel-mock dependencies in your classpath. If you are using Maven, add the following to your pom.xml:

xml
<dependencies>
    <dependency>
        <groupId>org.apache.camel</groupId>
        <artifactId>camel-core</artifactId>
        <version>3.11.0</version>
    </dependency>
    <dependency>
        <groupId>org.apache.camel</groupId>
        <artifactId>camel-mock</artifactId>
        <version>3.11.0</version>
    </dependency>
</dependencies>