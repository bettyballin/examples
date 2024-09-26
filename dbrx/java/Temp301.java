import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

public class CustomServer {

    public void customize(Server server) {
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        AnnotationConfigWebApplicationContext webCtx = new AnnotationConfigWebApplicationContext();
        // Assuming WebSecurityConfig and WebAppInitializer are in the same package as CustomServer
        webCtx.register(CustomServer.class.getPackage().getName() + ".WebSecurityConfig", 
                        CustomServer.class.getPackage().getName() + ".WebAppInitializer");
        context.setContextPath("/");
        context.setAttribute("org.springframework.web.context.WebApplicationContext.ROOT", webCtx);
        server.setHandler(context);

        FilterHolder filterHolder = new FilterHolder(new DelegatingFilterProxy());
        filterHolder.setName("springSecurityFilterChain");
        filterHolder.setInitParameter("contextAttribute", "org.springframework.web.context.WebApplicationContext.ROOT");

        EnumSet<DispatcherType> dispatcherTypes = EnumSet.of(DispatcherType.REQUEST, DispatcherType.ERROR, DispatcherType.ASYNC);

        context.addFilter(filterHolder, "/*", dispatcherTypes);
    }

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        new CustomServer().customize(server);
        server.start();
        server.join();
    }
}