public class MyApi {
    final String myUrl;

    public MyApi(String urlString) {
        // Verify that urlString points to an approved server
        if (!checkApprovedUrl(urlString)) throw new IllegalArgumentException();
        myUrl = urlString;
    }

    private boolean checkApprovedUrl(String urlString) {
        // Dummy implementation, replace with real logic to check approved URLs
        return urlString != null && urlString.startsWith("https://approvedserver.com");
    }

    public static void main(String[] args) {
        try {
            MyApi api = new MyApi("https://approvedserver.com/resource");
            System.out.println("API created with URL: " + api.myUrl);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid URL provided");
        }
    }
}