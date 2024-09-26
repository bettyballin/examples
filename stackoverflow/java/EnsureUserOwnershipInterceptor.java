import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnsureUserOwnershipInterceptor implements MethodInterceptor {

    @Autowired
    private AuthenticationService authenticationService;

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object[] arguments = invocation.getArguments();
        // Assuming the first argument is BookDTO and it has a getOwnerId method
        BookDTO book = (BookDTO) arguments[0];
        User currentUser = authenticationService.getCurrentUser();
        
        if (book.getOwnerId().equals(currentUser.getId())) {
            return invocation.proceed();
        } else {
            throw new UnauthorizedAccessException("User does not own the book.");
        }
    }
}

// Dummy classes and interfaces for the sake of compilation
class AuthenticationService {
    User getCurrentUser() {
        return new User(); // Implementation omitted
    }
}

class BookDTO {
    String getOwnerId() {
        return "ownerId"; // Implementation omitted
    }
}

class User {
    String getId() {
        return "userId"; // Implementation omitted
    }
}

class UnauthorizedAccessException extends RuntimeException {
    public UnauthorizedAccessException(String message) {
        super(message);
    }
}