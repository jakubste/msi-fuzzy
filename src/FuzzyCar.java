import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.rule.FuzzyRuleSet;
public class FuzzyCar {

    FuzzyRuleSet fuzzyRuleSet;

    public double x = 0;

    public FuzzyCar() {
        try {
            String fileName = "src/car.fcl";

            FIS fis = FIS.load(fileName,false);
            fuzzyRuleSet = fis.getFuzzyRuleSet();
            // fuzzyRuleSet.chart();
            // Uncomment line above to see charts with variables

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Hole hole) {
        int odleglosc = 200 - hole.y;
        int przesuniecie = Double.valueOf(hole.x - x).intValue();

        fuzzyRuleSet.setVariable("odleglosc", odleglosc);
        fuzzyRuleSet.setVariable("przesuniecie", przesuniecie);
        fuzzyRuleSet.evaluate();
        double change = fuzzyRuleSet.getVariable("zmiana_kierunku").getLatestDefuzzifiedValue();
        x += change / 10;
    }

    public static void main(String args[]) {
        FuzzyCar car = new FuzzyCar();
        Hole hole = Hole.getInstance();
        car.update(hole);
    }

}