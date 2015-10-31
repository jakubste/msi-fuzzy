import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.rule.FuzzyRuleSet;

import java.util.Scanner;

public class FuzzyCar {

    public static void main(String[] args) throws Exception {
        try {
            String fileName = "src/car.fcl";

            Scanner scanIn = new Scanner(System.in);
            String input;

            System.out.println("Podaj odleglosc od dziury");
            input = scanIn.nextLine();
            int odleglosc = Integer.parseInt(input);
            System.out.println("Podaj przesuniecie dziury");
            input = scanIn.nextLine();
            int przesuniecie = Integer.parseInt(input);

            FIS fis = FIS.load(fileName,false);

            //wyswietl wykresy funkcji fuzyfikacji i defuzyfikacji
            FuzzyRuleSet fuzzyRuleSet = fis.getFuzzyRuleSet();
            fuzzyRuleSet.chart();

//            zadaj wartosci wejsciowe
            fuzzyRuleSet.setVariable("odleglosc", odleglosc);
            fuzzyRuleSet.setVariable("przesuniecie", przesuniecie);
//            logika sterownika
            fuzzyRuleSet.evaluate();
//
//            graficzna prezentacja wyjscia
            fuzzyRuleSet.getVariable("zmiana_kierunku").chartDefuzzifier(true);
//
            System.out.println(fuzzyRuleSet);

        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Niepoprawna liczba parametrow. Przyklad: java FuzzyExample string<plik_fcl> int<poziom natezenia> int<pora dnia>");
        } catch (NumberFormatException ex) {
            System.out.println("Niepoprawny parametr. Przyklad: java FuzzyExample string<plik_fcl> int<poziom natezenia> int<pora dnia>");
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

}