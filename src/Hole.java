import java.util.Random;

/**
 * Created by kuba on 31.10.15.
 */

public class Hole {
    public int x;
    public int y;
    Random generator = new Random();

    private Hole() {
        x = generator.nextInt(200) - 100;
        y = 100;
    }

    private static Hole _instance = null;

    public static Hole getInstance() {
        if (_instance == null) {
            _instance = new Hole();
        }
        return _instance;
    }

    public void update(FuzzyCar car) {
        if (y < 200) {
            y++;
        } else {
            if (car.x > 0)
                x = Double.valueOf(car.x).intValue() + generator.nextInt(50);
            else
                x = Double.valueOf(car.x).intValue() - generator.nextInt(50);
            y = 0;
        }
    }
}
