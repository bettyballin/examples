import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.core.context.SecurityContextThreadLocal;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.core.Authentication;

import java.util.function.Supplier;

public final class CustomTaskDecorator extends AbstractDelegatingSecurityContextRunnable {

    public static Runnable decorate(Runnable runnable) {
        return new CustomTaskDecorator(null, runnable);
    }

    private CustomTaskDecorator(SecurityContext securityContextToPropagate, Runnable target) {
        super(target, securityContextToPropagate != null ?
                () -> securityContextToPropagate :
                SecurityContextHolder::getContext);
    }
}

abstract class AbstractDelegatingSecurityContextRunnable implements Runnable {
    private final Runnable delegate;
    private final Supplier<SecurityContext> securityContextSupplier;
    private SecurityContext originalSecurityContext;

    public AbstractDelegatingSecurityContextRunnable(Runnable delegate, Supplier<SecurityContext> securityContextSupplier) {
        this.delegate = delegate;
        this.securityContextSupplier = securityContextSupplier;
    }

    @Override
    public void run() {
        SecurityContext original = SecurityContextHolder.getContext();
        try {
            SecurityContextHolder.setContext(securityContextSupplier.get());
            delegate.run();
        } finally {
            SecurityContextHolder.setContext(original);
        }
    }
}