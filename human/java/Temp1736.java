public class Temp1736 {
    public static void main(String[] args) {
        User user = new User("Bill", "Pizza", true);
        System.out.println("Name: " + user.getName());
        System.out.println("Favorite Food: " + user.getFavFood());
        System.out.println("Online: " + user.isOnline());
    }
}

class User {
    private String name;
    private String favFood;
    private boolean online;

    public User(String name, String favFood, boolean online) {
        this.name = name;
        this.favFood = favFood;
        this.online = online;
    }

    public String getName() {
        return name;
    }

    public String getFavFood() {
        return favFood;
    }

    public boolean isOnline() {
        return online;
    }
}