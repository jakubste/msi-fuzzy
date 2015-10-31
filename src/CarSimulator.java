import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by kuba on 31.10.15.
 */
public class CarSimulator {

    static Road road;
    static JFrame frame;

    public static void main(String[] args) {

        road = new Road();

        frame = new JFrame();
        frame.setLayout(new GridLayout(1, 1));
        frame.add(road);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ActionListener repaint = evt -> frame.repaint();
        new Timer(20, repaint).start();
    }

}
