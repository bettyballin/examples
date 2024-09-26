public class Temp563 {
    public static void main(String[] args) {
        // Placeholder class to simulate HttpSecurity object and its methods
        class HttpSecurity {
            public ResourceConfigurer staticResources() {
                return new ResourceConfigurer();
            }
        }

        // Placeholder class to simulate the internal configuration
        class ResourceConfigurer {
            public ResourceConfigurer resource(String pattern) {
                System.out.println("Resource pattern: " + pattern);
                return this;
            }

            public HeaderConfigurer withHttpHeaders(String header, String value) {
                System.out.println("Header: " + header + ", Value: " + value);
                return new HeaderConfigurer();
            }

            public ResourceConfigurer withoutCsrf() {
                System.out.println("CSRF protection disabled");
                return this;
            }
        }

        // Placeholder class to simulate header configuration
        class HeaderConfigurer extends ResourceConfigurer {
        }

        // Simulating HttpHeaders class
        class HttpHeaders {
            public static final String X_FRAME_OPTION = "X-Frame-Options";
        }

        // Simulating the actual usage in the main method
        HttpSecurity httpSecurity = new HttpSecurity();
        httpSecurity.staticResources()
            .resource("/resources/**")
            .withHttpHeaders(HttpHeaders.X_FRAME_OPTION, "SAMEORIGIN")
            .withoutCsrf();
    }
}