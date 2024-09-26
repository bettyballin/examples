public class Temp395 {
    public static void main(String[] args) {

        String apiKey = System.getenv("GOOGLE_MAPS_API_KEY");
        if (apiKey == null) {
            throw new RuntimeException("Google Maps API key not found in environment variables.");
        }

        // Use the obtained Google Maps API Key
        System.out.println("API Key: " + apiKey);

    }
}