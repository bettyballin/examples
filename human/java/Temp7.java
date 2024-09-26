import javax.swing.JApplet;
import java.awt.Graphics;

public class Temp7 extends JApplet {
    public void init() {
        // Initialization code for the applet can go here
    }

    public void paint(Graphics g) {
        g.drawString("Hello, Applet!", 20, 20);
    }

    public static void main(String[] args) {
        // Main method typically isn't used in applets, but let's keep it simple
        System.out.println("Applet running!");
    }
}