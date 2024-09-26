import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Temp2739 {
    public static void main(String[] args) {
        // Setup a basic JFrame
        JFrame frame = new JFrame("Temp2739");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Create a button
        JButton button = new JButton("Click me");
        frame.getContentPane().add(button);

        // Add action listener to the button
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Simulate the original JavaScript functionality
                String token = "dummy_csrf_token"; // Simulated CSRF token
                String header = "X-CSRF-Token"; // Simulated CSRF header

                System.out.println("Setting header: " + header + " with token: " + token);
                // Here you would set the header in a real AJAX request
            }
        });

        // Display the JFrame
        frame.setVisible(true);
    }
}