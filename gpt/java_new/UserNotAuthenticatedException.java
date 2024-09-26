import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;

public class UserNotAuthenticatedException extends AuthenticationException {
    public UserNotAuthenticatedException(String msg) {
        super(msg);
    }
}

// Assuming that getCurrentUser() and isRequired() are defined somewhere else in the codebase.
// Assuming that CurrentUserId is an annotation defined somewhere else in the codebase.
// Assuming that User is a class defined somewhere else in the codebase and has a getId() method.
// Assuming that AuthenticationException is a class defined somewhere else in the codebase.

protected Object resolveName(String name, MethodParameter parameter, NativeWebRequest request) throws Exception {
    User currentUser = getCurrentUser(); // getCurrentUser() should be defined somewhere
    if (currentUser != null) {
        return currentUser.getId(); // getId() should be defined in User class
    } else if (isRequired(parameter.getParameterAnnotation(CurrentUserId.class))) { // isRequired should be defined somewhere
        throw new UserNotAuthenticatedException("User is not authenticated");
    }
    return null;
}