import java.util.List;
import java.util.ArrayList;

public class Temp3024 {

    // Mock Order class for demonstration
    public static class Order {
        private int id;
        private String description;

        public Order(int id, String description) {
            this.id = id;
            this.description = description;
        }

        public int getId() {
            return id;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public String toString() {
            return "Order{id=" + id + ", description='" + description + "'}";
        }
    }

    // Mock YourBean class for demonstration
    public static class YourBean {
        public boolean hasPermission(Object principal, Integer id, String role) {
            // For demonstration purposes, assume all permissions are granted
            return true;
        }
    }

    public static void main(String[] args) {
        Temp3024 temp = new Temp3024();
        List<Order> orders = temp.ordersForUsers(1);
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    // Assuming a role-based permission check
    //@PreAuthorize("@yourBean.hasPermission(principal, #id, 'admin')")
    public List<Order> ordersForUsers(Integer id) {
        // Mock implementation for demonstration
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1, "Order 1"));
        orders.add(new Order(2, "Order 2"));
        return orders;
    }
}