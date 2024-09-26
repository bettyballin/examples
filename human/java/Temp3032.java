public class Temp3032 {
    public static void main(String[] args) {
        Route homeRoute = new Route(
            "", 
            new HomeComponent(), 
            new RouteData(new String[]{}, "home.title")
        );
    }
}

class Route {
    private String path;
    private HomeComponent component;
    private RouteData data;

    public Route(String path, HomeComponent component, RouteData data) {
        this.path = path;
        this.component = component;
        this.data = data;
    }

    // Getters and setters (if needed)
}

class HomeComponent {
    // HomeComponent implementation
}

class RouteData {
    private String[] authorities;
    private String pageTitle;

    public RouteData(String[] authorities, String pageTitle) {
        this.authorities = authorities;
        this.pageTitle = pageTitle;
    }

    // Getters and setters (if needed)
}