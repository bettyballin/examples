public class Temp2499 {
    public static void main(String[] args) {
        // Assuming connector is an instance of a class that has setXpoweredBy and setAttribute methods
        Connector connector = new Connector();
        connector.setXpoweredBy(false);
        connector.setAttribute("server", "");
    }
}

// Dummy Connector class for demonstration purposes. 
// Replace this with the actual class definition you intend to use.
class Connector {
    public void setXpoweredBy(boolean flag) {
        System.out.println("X-Powered-By set to: " + flag);
    }

    public void setAttribute(String key, String value) {
        System.out.println("Attribute set: " + key + " = " + value);
    }
}