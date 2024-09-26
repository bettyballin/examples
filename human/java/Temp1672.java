import javax.swing.JApplet;
import javax.swing.JFrame;

public class Temp1672 extends JApplet {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Applet in Frame");
        Temp1672 applet = new Temp1672();
        frame.add(applet);
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        applet.init();
        applet.start();
    }

    @Override
    public void init() {
        // Initialize your applet here
    }

    @Override
    public void start() {
        // Start your applet here
    }

    @Override
    public void stop() {
        // Stop your applet here
    }

    @Override
    public void destroy() {
        // Destroy your applet here
    }
}