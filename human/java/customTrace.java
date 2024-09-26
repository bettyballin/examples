import org.springframework.stereotype.Component;
import org.springframework.boot.actuate.trace.InMemoryTraceRepository;
import org.springframework.boot.actuate.trace.Trace;
import org.springframework.boot.actuate.trace.TraceRepository;

import java.util.List;
import java.util.Map;

@Component
public class CustomTrace implements TraceRepository {

    private final TraceRepository lastOneHundretLogs = new InMemoryTraceRepository();

    @Override
    public List<Trace> findAll() {
        return lastOneHundretLogs.findAll();
    }

    @Override
    public void add(Map<String, Object> map) {
        lastOneHundretLogs.add(map);
    }
}