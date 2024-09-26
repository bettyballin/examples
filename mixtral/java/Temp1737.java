public class Temp1737 {
    public static void main(String[] args) {
        configureRequestHeaders("Bearer <your_auth_token>");
    }

    public static void configureRequestHeaders(String authToken) {
        // Assuming comeTD is a custom class you have that handles configuration
        ComeTD comeTD = new ComeTD();
        comeTD.configure(authToken);
    }
}

class ComeTD {
    public void configure(String authToken) {
        System.out.println("Configuring request headers with token: " + authToken);
        // Add your configuration logic here
    }
}