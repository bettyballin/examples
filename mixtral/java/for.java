import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.google.gwt.user.client.rpc.RemoteService;

// Define the exception
@SuppressWarnings("serial")
class UnauthenticatedException extends Exception {}

// Define the interface
public interface SecuredRemoteService extends RemoteService {
    void validateUser() throws UnauthenticatedException;
}

// Create an abstract base class for all service implementations
public abstract class SecuredServiceImpl<T> extends RemoteServiceServlet implements SecuredRemoteService {

    @Override
    public final void validateUser() throws UnauthenticatedException {
        // Check authentication here
        boolean authorized = ...; // Replace with actual authentication logic

        if (!authorized) {
            throw new UnauthenticatedException();
        }
    }
}

// Create an abstract base class for all service asynchronous interfaces
public interface SecuredAsyncCallback<T> extends AsyncCallback<T> {

    @Override
    default void onFailure(Throwable caught) {
        // Check for unauthenticated exceptions
        Throwable cause = caught;

        while (cause != null) {
            if (cause instanceof UnauthenticatedException) {
                handleUnauthorized();
                return;
            } else {
                cause = cause.getCause();
            }
        }

        // If not an UnauthenticatedException, call the default onFailure implementation
        onFailure(caught);
    }

    // Override this method to handle unauthenticated exceptions
    void handleUnauthorized();
}