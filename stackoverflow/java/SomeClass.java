import org.springframework.security.access.prepost.PreAuthorize;

public class SomeClass {

    @PreAuthorize("hasRole(T(fully.qualified.OtherClass).ROLE)")
    public void someMethod() {
        // method implementation
    }
}

class fully {
    public static class qualified {
        public static class OtherClass {
            public static final String ROLE = "ROLE_USER";
        }
    }
}