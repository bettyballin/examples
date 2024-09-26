public class Temp913 {
    public static void main(String[] args) {
        String urlBase = "http://example.com";
        String currentPath = "home";
        
        // Generate the HTML anchor tag with the given variables
        String anchorTag = "<a href=\"" + urlBase + "?currentPath=" + currentPath + "\"></a>";
        
        System.out.println(anchorTag);
    }
}