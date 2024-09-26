public class Temp3033 {
    public static void main(String[] args) {
        // Simulating the original intention of the code snippet
        Route[] fooRoute = {
            new Route(new String[]{"ROLE_STUDENT", "ROLE_PROFESSOR"})
        };

        // Outputting the roles to demonstrate functionality
        for (Route route : fooRoute) {
            System.out.println("Authorities: " + String.join(", ", route.data.authorities));
        }
    }
}

class Route {
    Data data;

    Route(String[] authorities) {
        this.data = new Data(authorities);
    }
}

class Data {
    String[] authorities;

    Data(String[] authorities) {
        this.authorities = authorities;
    }
}