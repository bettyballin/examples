import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ResponseBody;

class SomeObject {
    // Assume there are some fields and methods here
}

public class Temp188 {
    public static void main(String[] args) {
        Temp188 temp188 = new Temp188();
        // You can call temp188.someMethodSignature(authentication) here if you have an Authentication object
    }

    @ResponseBody
    public SomeObject someMethodSignature(Authentication authentication) {
        // Sample implementation
        return new SomeObject();
    }
}


becomes


import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.ResponseBody;

class SomeObject {
    // Assume there are some fields and methods here
}

import org.springframework.web.bind.annotation.RestController;

@RestController
public class Temp188 {
    public static void main(String[] args) {
        Temp188 temp188 = new Temp188();
        // You can call temp188.someMethodSignature(authentication) here if you have an Authentication object
    }

    @ResponseBody
    public SomeObject someMethodSignature(Authentication authentication) {
        // Sample implementation
        return new SomeObject();
    }
}