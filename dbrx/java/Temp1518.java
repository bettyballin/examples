public class Temp1518 {
    public static void main(String[] args) {
        AccountDTO dto = new AccountDTO("John", "Doe", "john.doe@example.com", "USA", "password123", "password123");
        ModelAndView mav = new ModelAndView();
        mav.addObject("account", new AccountDTO(dto.getFirstName(), dto.getLastName(), dto.getEmail(), dto.getCountry(), dto.getPassword(), dto.getConfirmPassword()));
    }
}

class AccountDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String country;
    private String password;
    private String confirmPassword;

    public AccountDTO(String firstName, String lastName, String email, String country, String password, String confirmPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.country = country;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getCountry() {
        return country;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    @Override
    public String toString() {
        return "AccountDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}

// Mocking the ModelAndView class to make this code executable
class ModelAndView {
    public void addObject(String key, AccountDTO value) {
        System.out.println("Added object: " + key + " -> " + value);
    }
}