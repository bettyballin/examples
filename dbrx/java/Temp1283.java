public class Temp1283 {
    public static void main(String[] args) {
        Service service = new Service();
        service.setAuthoritiesByUsernameQuery("SELECT u.username, r.name FROM users_roles ur INNER JOIN role r ON ur.role_id = r.id INNER JOIN user u ON ur.user_id = u.id WHERE u.username = ?");
        System.out.println("Query set successfully.");
    }
}

class Service {
    public void setAuthoritiesByUsernameQuery(String query) {
        // Assuming this method sets the query for further use, adding a simple print statement for demonstration.
        System.out.println("Query: " + query);
    }
}