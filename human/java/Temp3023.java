import java.util.List;

public class Temp3023 {
    public static void main(String[] args) {
        Temp3023 temp = new Temp3023();
        // Example call to the ordersForUsers method
        List<Order> orders = temp.ordersForUsers(1);
    }

    // Assuming Order is a predefined class
    public static class Order {
        // Order properties and methods
    }

    @PreAuthorize("principal?.id == #id")
    public List<Order> ordersForUsers(Integer id) {
        // do something
        return List.of(); // Return an empty list for now
    }
}

// Mocking the PreAuthorize annotation for the sake of completeness
@interface PreAuthorize {
    String value();
}