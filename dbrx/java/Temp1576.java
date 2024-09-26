import reactor.core.publisher.Mono;

public class Temp1576 {
    public static void main(String[] args) {
        Temp1576 temp = new Temp1576();
        MyAppUserDetails userDetails = new MyAppUserDetails("firstName", "lastName", "email", 3, 5);
        Mono<MyAppUserDetails> updatedUserDetailsMono = temp.updateUserDetails(userDetails);
        updatedUserDetailsMono.subscribe(updatedUserDetails -> {
            System.out.println("Updated User Details: " + updatedUserDetails);
        });
    }

    public Mono<MyAppUserDetails> updateUserDetails(MyAppUserDetails userDetails) {
        // Update the UserDetails based on your requirements.
        return Mono.just(new MyAppUserDetails("newFirstName", "lastName", "email", 1, 4));
    }
}

class MyAppUserDetails {
    private String firstName;
    private String lastName;
    private String email;
    private int param1;
    private int param2;

    public MyAppUserDetails(String firstName, String lastName, String email, int param1, int param2) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.param1 = param1;
        this.param2 = param2;
    }

    @Override
    public String toString() {
        return "MyAppUserDetails{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", param1=" + param1 +
                ", param2=" + param2 +
                '}';
    }
}