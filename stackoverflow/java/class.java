import org.springframework.beans.factory.InitializingBean;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class EventListener implements InitializingBean {

    Log log = LogFactory.getLog(this.getClass());

    EventDispatcher eventDispatcher;

    @Override
    public void afterPropertiesSet() throws Exception {
        eventDispatcher.registerListener(this);
    }

    public abstract boolean canHandle(Object event);

    public abstract void handle(Object event);

    public void setEventDispatcher(EventDispatcher eventDispatcher) {
        this.eventDispatcher = eventDispatcher;
    }
}

interface EventDispatcher {
    void registerListener(EventListener listener);
}