import java.io.Serializable;
import java.util.List;

public class ListWrapper {
    private List<Test> tests;

    public Serializable getId() {
        // Assuming 'some id' should be replaced with an actual serializable object.
        // For the sake of this example, let's return a simple string ID.
        return "some_id";
    }
}

class Test implements Serializable {
    private static final long serialVersionUID = 1L;

    // Test class details
}