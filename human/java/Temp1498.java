public class Temp1498 {
    public static void main(String[] args) {
        // Simulated configuration settings
        String directory = "/home/*/public_html"; // You can change this location
        int maxConnPerIP = 1;
        String[] onlyIPLimit = {"audio/mpeg", "video"};

        // Print configuration settings to demonstrate functionality
        System.out.println("Directory: " + directory);
        System.out.println("MaxConnPerIP: " + maxConnPerIP);
        System.out.print("OnlyIPLimit: ");
        for (String mimeType : onlyIPLimit) {
            System.out.print(mimeType + " ");
        }
    }
}