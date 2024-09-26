public class Temp2191 {

    public static void main(String[] args) {
        UrlAuthorization urlAuthorization = new UrlAuthorization();
        assert urlAuthorization.isAccessible("/accounts") == false;
        assert urlAuthorization.isAccessible("/") == true;
    }
}

class UrlAuthorization {
    public boolean isAccessible(String url) {
        // Simple example logic for URL authorization
        return !url.equals("/accounts");
    }
}