public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("your.fqdn.class.name");
        } catch (ClassNotFoundException e) {
            // my class isn't there!
            System.out.println("Class not found!");
        }
    }
}