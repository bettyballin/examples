import java.util.ArrayList;
import java.util.List;

class ScopeRepo {
    public List<String> getSegments() {
        // Mock implementation for demonstration
        List<String> segments = new ArrayList<>();
        segments.add("Segment1");
        segments.add("Segment2");
        return segments;
    }
}

public class Temp2923 {
    public static void main(String[] args) {
        ScopeRepo scopeRepo = new ScopeRepo();
        ArrayList<String> segments = new ArrayList<>(scopeRepo.getSegments());
        System.out.println(segments);
    }
}