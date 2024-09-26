public class Temp2604 {
    public static void main(String[] args) {
        if (isOwner()) {
            // question entity logic here
            System.out.println("Authorized access to question entity.");
        } else {
            System.out.println("Access denied.");
        }
    }

    public static boolean isOwner() {
        // Dummy implementation, replace with actual owner check logic
        return true; // or false based on your logic
    }
}