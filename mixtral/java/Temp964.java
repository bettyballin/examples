import java.util.Map;

public class Temp964 {
    // Hypothetical methods to get username and password from request
    private String getUsernameFromRequest() {
        return "exampleUsername"; // Replace with actual implementation
    }

    private String getPasswordFromRequest() {
        return "examplePassword"; // Replace with actual implementation
    }

    // Mock superclass to provide methods used in the code
    public static class SuperClass {
        public Map<String, String[]> getParameterMap() {
            // Mock implementation, replace with actual data fetching
            return Map.of("param1", new String[]{"value1", "value2"});
        }

        public String[] getParameterValues(String name) {
            return getParameterMap().get(name);
        }

        public String getParameter(String name) {
            return "defaultValue"; // Replace with actual implementation
        }
    }

    public static class MyRequest extends SuperClass {
        @Override
        public String getParameter(String name) {
            if ("j_username".equalsIgnoreCase(name)) {
                return this.getUsernameFromRequest();
            } else if (super.getParameterMap().containsKey(name)) {
                String[] values = super.getParameterValues(name);
                StringBuilder sb = new StringBuilder();
                for (String val : values) {
                    sb.append("&").append(val);
                }
                return sb.toString().substring(1);
            } else if ("j_password".equalsIgnoreCase(name)) {
                return this.getPasswordFromRequest();
            }
            return super.getParameter(name);
        }

        private String getUsernameFromRequest() {
            return "exampleUsername";
        }

        private String getPasswordFromRequest() {
            return "examplePassword";
        }
    }

    public static void main(String[] args) {
        MyRequest request = new MyRequest();
        System.out.println(request.getParameter("j_username"));
        System.out.println(request.getParameter("param1"));
        System.out.println(request.getParameter("j_password"));
        System.out.println(request.getParameter("unknownParam"));
    }
}