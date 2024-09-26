import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.ExecuteContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultExecuteListener;

public class JooqConfig {
    public static void configure(Configuration configuration) {
        // Register the execute listener
        configuration.executeListenerProvider(() -> new SessionVariableExecuteListener());
    }

    public static void main(String[] args) {
        DefaultConfiguration configuration = new DefaultConfiguration();
        configuration.set(SQLDialect.DEFAULT);
        configure(configuration);
        // Example usage: You can now use the configuration object to create a DSLContext and work with jOOQ
        DSLContext context = DSL.using(configuration);
        // Use the context to execute queries, e.g.
        // context.selectFrom(MY_TABLE).fetch();
    }
}

class SessionVariableExecuteListener extends DefaultExecuteListener {
    @Override
    public void start(ExecuteContext ctx) {
        // Implement your logic here
        System.out.println("SessionVariableExecuteListener started.");
    }
}