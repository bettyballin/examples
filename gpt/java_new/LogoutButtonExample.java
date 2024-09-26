import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogoutButtonExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Logout Example");
        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Logout button clicked");
                // Handle logout logic here
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(logoutButton);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}