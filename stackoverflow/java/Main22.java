// Implementation of your custom security manager
}

public class Main22 {
    public static void main(String[] args) {
        SecurityManager sm = new MySecurityManager();
        System.setSecurityManager(sm);
        // Rest of your code
    }
}