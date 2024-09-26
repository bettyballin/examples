public class Temp2367 {
    public static void main(String[] args) {
        System.out.println("Zuul Routes Configuration Example");
        
        // Simulate Zuul configuration
        ZuulConfig zuulConfig = new ZuulConfig();
        zuulConfig.addRoute(new ZuulRoute("/instances/**", "instance-service", false));
        zuulConfig.addRoute(new ZuulRoute("/restore/**", "restore-service", false));
        
        zuulConfig.printConfig();
    }
}

class ZuulConfig {
    private List<ZuulRoute> routes;

    public ZuulConfig() {
        this.routes = new ArrayList<>();
    }

    public void addRoute(ZuulRoute route) {
        this.routes.add(route);
    }

    public void printConfig() {
        for (ZuulRoute route : routes) {
            System.out.println("Path: " + route.getPath() + ", ServiceId: " + route.getServiceId() + ", StripPrefix: " + route.isStripPrefix());
        }
    }
}

class ZuulRoute {
    private String path;
    private String serviceId;
    private boolean stripPrefix;

    public ZuulRoute(String path, String serviceId, boolean stripPrefix) {
        this.path = path;
        this.serviceId = serviceId;
        this.stripPrefix = stripPrefix;
    }

    public String getPath() {
        return path;
    }

    public String getServiceId() {
        return serviceId;
    }

    public boolean isStripPrefix() {
        return stripPrefix;
    }
}