import java.util.List;

class User {
    private int bitcoin;

    public int getBitcoin() {
        return bitcoin;
    }
}

class UserRepository {
    public List<User> findByRegName(String regName) {
        // This should be implemented to retrieve users from a data source.
        return List.of(new User(), new User()); // Dummy data for example
    }
}

class Model {
    public void addAttribute(String key, Object value) {
        // This should be implemented to add attributes to the model.
        System.out.println(key + ": " + value);
    }
}

public class Temp3308 {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        Model model = new Model();
        String regName = "exampleRegName"; // Example registration name

        List<User> users = userRepository.findByRegName(regName);
        int total = 0;
        for (User user : users) {
            total = total + user.getBitcoin();
        }
        model.addAttribute("totalBitcoin", total);
    }
}