import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service("userCreds")
@ConditionalOnProperty(name = "use.static.creds", havingValue = "false", matchIfMissing = true)
public class UserInputCredentialsServiceImpl implements MyService {

    @Override
    public void doSomething() {
        // Prompt user for credentials here.
        System.out.println("Prompting user for credentials...");
    }

    public static void main(String[] args) {
        // Simulating Spring Boot application context
        UserInputCredentialsServiceImpl service = new UserInputCredentialsServiceImpl();
        service.doSomething();
    }
}

interface MyService {
    void doSomething();
}

 Becomes:


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service("userCreds")
@ConditionalOnProperty(name = "use.static.creds", havingValue = "false", matchIfMissing = true)
public class UserInputCredentialsServiceImpl implements MyService {

    @Override
    public void doSomething() {
        // Prompt user for credentials here.
        System.out.println("Prompting user for credentials...");
    }

    public static void main(String[] args) {
        // Simulating Spring Boot application context
        UserInputCredentialsServiceImpl service = new UserInputCredentialsServiceImpl();
        service.doSomething();
    }
}

interface MyService {
    void doSomething();
}

 Changes to:



import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service("userCreds")
@ConditionalOnProperty(name = "use.static.creds", havingValue = "false", matchIfMissing = true)
public class UserInputCredentialsServiceImpl implements MyService {

    @Override
    public void doSomething() {
        // Prompt user for credentials here.
        System.out.println("Prompting user for credentials...");
    }

    public static void main(String[] args) {
        // Simulating Spring Boot application context
        UserInputCredentialsServiceImpl service = new UserInputCredentialsServiceImpl();
        service.doSomething();
    }
}

interface MyService {
    void doSomething();
}

is still the same code so I just added the interface to its own file:


//MyService.java
public interface MyService {
    void doSomething();
}



//UserInputCredentialsServiceImpl.java
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service("userCreds")
@ConditionalOnProperty(name = "use.static.creds", havingValue = "false", matchIfMissing = true)
public class UserInputCredentialsServiceImpl implements MyService {

    @Override
    public void doSomething() {
        // Prompt user for credentials here.
        System.out.println("Prompting user for credentials...");
    }

    public static void main(String[] args) {
        // Simulating Spring Boot application context
        UserInputCredentialsServiceImpl service = new UserInputCredentialsServiceImpl();
        service.doSomething();
    }
}