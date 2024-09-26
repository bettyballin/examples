import org.springframework.security.core.annotation.AuthenticationPrincipal;

// Usage example in a method
public void someMethod(@AuthenticationPrincipal MyUserDetails customUser) {
    // method implementation
}