import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class Temp580 {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Country Selector");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 200);

            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());

            JLabel label = new JLabel("Select a country:");
            panel.add(label, BorderLayout.NORTH);

            JComboBox<String> countryComboBox = new JComboBox<>();
            panel.add(countryComboBox, BorderLayout.CENTER);

            // Simulate AJAX call
            List<String> countries = fetchCountries();
            for (String country : countries) {
                countryComboBox.addItem(country);
            }

            frame.add(panel);
            frame.setVisible(true);
        });
    }

    // Simulate fetching countries from a server
    private static List<String> fetchCountries() {
        return Arrays.asList("USA", "Canada", "Mexico", "France", "Germany");
    }
}