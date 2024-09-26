import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Temp2188 {
    public static void main(String[] args) {
        // Setup a basic GUI for demonstration
        JFrame frame = new JFrame("Temp2188 Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        
        JButton button = new JButton("Load Page");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Simulating AJAX call using SwingWorker
                new SwingWorker<String, Void>() {
                    @Override
                    protected String doInBackground() throws Exception {
                        // Simulated server response
                        Thread.sleep(2000); // Simulate network delay
                        return "<div>Some HTML content</div>";
                    }

                    @Override
                    protected void done() {
                        try {
                            String data = get();
                            JOptionPane.showMessageDialog(frame, data);
                            if (data.contains("loginpageflag")) {
                                JOptionPane.showMessageDialog(frame, "Redirecting to login page...");
                                // Simulate redirection
                            } else {
                                // Update GUI component
                                JTextArea textArea = new JTextArea();
                                textArea.setText(data);
                                frame.getContentPane().removeAll();
                                frame.getContentPane().add(new JScrollPane(textArea), BorderLayout.CENTER);
                                frame.revalidate();
                                frame.repaint();
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }.execute();
            }
        });

        frame.getContentPane().add(button, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}