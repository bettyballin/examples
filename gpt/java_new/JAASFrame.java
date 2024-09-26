import javax.swing.*;

public class JAASFrame extends JFrame {
    // Constructor for JAASFrame
    public JAASFrame() {
        // Initialize frame components
        setTitle("JAAS Frame");
        setSize(300, 200);
        // Other initialization code if needed
    }

    public static void main(final String[] args) {
        // Set the security policy before creating the security manager.
        System.setProperty("java.security.policy", "file:/C:/Users/kBPersonal/Documents/NetBeansProjects/JAASTest/JAASTest.policy");

        // Now instantiate and set the security manager.
        System.setSecurityManager(new SecurityManager());

        EventQueue.invokeLater(() -> {
            JFrame frame = new JAASFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}