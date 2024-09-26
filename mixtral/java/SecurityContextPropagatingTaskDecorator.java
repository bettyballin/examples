import org.springframework.core.task.TaskDecorator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.AnonymousAuthenticationToken;

public class SecurityContextPropagatingTaskDecorator implements TaskDecorator {

    @Override
    public Runnable decorate(Runnable runnable) {
        return () -> {
            SecurityContext context = SecurityContextHolder.createEmptyContext();
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();

            if (auth != null && !(auth instanceof AnonymousAuthenticationToken)) {
                context.setAuthentication(auth);
                SecurityContextHolder.setContext(context);

                try {
                    // Run the task with a new security context
                    runnable.run();
                } finally {
                    SecurityContextHolder.clearContext();
                }

                return;
            }

            try {
                // Run the task without any security context
                runnable.run();
            } catch (Exception e) {
                throw new IllegalStateException("Failed to propagate SecurityContext", e);
            }
        };
    }
}