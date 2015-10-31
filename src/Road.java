import javax.swing.*;
import java.awt.*;

public class Road extends JPanel {

    Hole hole;
    FuzzyCar car;

    public Road() {
        hole = Hole.getInstance();
        car = new FuzzyCar();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 200);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        hole.update(car);
        g.fillOval(hole.x + 200, hole.y, 10, 10);
        car.update(hole);
        g.fillRect(Double.valueOf(car.x).intValue() + 200, 190, 10, 10);
    }

}
