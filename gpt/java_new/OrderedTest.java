import the necessary package for the `@Order` annotation. Additionally, we need a test method to which this annotation would apply.

Assuming we're using JUnit 5, which includes the `@Order` annotation as part of the `org.junit.jupiter.api` package, here's how you could refactor the snippet:

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class OrderedTest {

    @Test
    @Order(1)
    void testMethod() {
        // test code goes here
    }
}