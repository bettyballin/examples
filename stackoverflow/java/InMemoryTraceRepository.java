import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
public class InMemoryTraceRepository implements TraceRepository {

    private static final Logger HTTP_LOGGER = LoggerFactory.getLogger("http-logger");

    @Override
    public List<Trace> findAll() {
        return null;
    }

    @Override
    public void add(Map<String, Object> map) {
        Trace trace = new Trace(new Date(), map);
        String traceInfo = trace.getInfo().toString();
        HTTP_LOGGER.info(traceInfo);
    }
}

interface TraceRepository {
    List<Trace> findAll();
    void add(Map<String, Object> map);
}

class Trace {
    private Date timestamp;
    private Map<String, Object> info;

    public Trace(Date timestamp, Map<String, Object> info) {
        this.timestamp = timestamp;
        this.info = info;
    }

    public Map<String, Object> getInfo() {
        return info;
    }
}