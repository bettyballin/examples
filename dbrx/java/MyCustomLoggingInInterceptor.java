import org.apache.cxf.interceptor.AbstractPhaseInterceptor;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.Phase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyCustomLoggingInInterceptor extends AbstractPhaseInterceptor<Message> {

    public MyCustomLoggingInInterceptor() {
        super(Phase.RECEIVE);
    }

    @Override
    public void handleMessage(Message message) {
        getLogger().info("Handling message: {}", message);
    }

    protected Logger getLogger() {
        return LoggerFactory.getLogger(MyCustomLoggingInInterceptor.class);
    }
}