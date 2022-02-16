package ClimateChange;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<ITemperature> list = new ArrayList<ITemperature>();
        ClimateAnalyzer ca = new ClimateAnalyzer(list);
        ca.runClimateAnalyzer();
    }
}
