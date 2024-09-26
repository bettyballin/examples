import java.io.Serializable;
import java.util.List;

public class ListWrapper {
    private List<Test> tests;

    public Serializable getId() {
        // Implement your logic to return some id
        return "someId"; // Example implementation, replace with actual logic
    }

    public static void main(String[] args) {
        ListWrapper lw = new ListWrapper();
        System.out.println(lw.getId());
    }
}

class Test {
    // Test class implementation
}