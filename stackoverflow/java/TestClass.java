import org.springframework.security.access.prepost.PreAuthorize;

public class TestClass {

    @PreAuthorize("@testBean.getTestValue()")
    public String testSpEL() {
        // Method implementation goes here
        return "someValue";
    }
}