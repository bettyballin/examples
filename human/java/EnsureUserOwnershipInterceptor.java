import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

@Component
public class EnsureUserOwnershipInterceptor implements MethodInterceptor {

    @Autowired
    private AuthenticationService authenticationService;

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        // 1. get the BookDTO argument from the invocation
        Object[] arguments = invocation.getArguments();
        BookDTO book = null;
        for (Object arg : arguments) {
            if (arg instanceof BookDTO) {
                book = (BookDTO) arg;
                break;
            }
        }

        // 2. get the current user from the auth service
        User currentUser = authenticationService.getCurrentUser();

        // 3. ensure the owner ID and the current user ID match
        if (book != null && !book.getOwnerId().equals(currentUser.getId())) {
            throw new IllegalAccessException("User does not own this book!");
        }

        // proceed with the invocation
        return invocation.proceed();
    }
}

class AuthenticationService {
    public User getCurrentUser() {
        // Dummy implementation for illustration
        return new User("123");
    }
}

class User {
    private String id;

    public User(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}

class BookDTO {
    private String ownerId;

    public BookDTO(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerId() {
        return ownerId;
    }
}