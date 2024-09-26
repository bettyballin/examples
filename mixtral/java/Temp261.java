public class Temp261 {
    public static void main(String[] args) {
        try {
            // Simulate some byte array as example
            String example = "Example string";
            java.io.ByteArrayOutputStream os = new java.io.ByteArrayOutputStream();
            os.write(example.getBytes("UTF-8"));

            // Convert bytes to string
            String file_string = new String(os.toByteArray(), "UTF-8").trim();
            System.out.print(file_string);
            
            // Simulate challenge string for comparison
            String challenge = "Example string";
            boolean result = file_string.equals(challenge);
            System.out.println("\nComparison result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}