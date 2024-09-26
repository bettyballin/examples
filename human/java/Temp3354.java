public class Temp3354 {
    public static void main(String[] args) {
        String hostConfig = "<host name=\"example.com\" alias=\"example.com\" default-web-module=\"myapp.war\">" +
                            "<access-log directory=\"${jboss.server.log.dir}/access\" prefix=\"myapp_access_log.\"/>" +
                            "</host>";
        System.out.println(hostConfig);
    }
}