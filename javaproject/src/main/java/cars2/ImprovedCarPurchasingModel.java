package cars2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ImprovedCarPurchasingModel {
    public static void main(String[] args){
        ImmutableCar defaultCar = new ImmutableCar("Honda", 2105, "Beige", 120.0);
        
        List<String> colors = new LinkedList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("White");
        colors.add("Black");
        colors.add("Beige");

        Map<ImmutableCar, Double> ranked = new HashMap<ImmutableCar, Double>();
        for(String color : colors){
            ImmutableCar car = defaultCar.setColor(color);
            ranked.put(car, TestDriver2.rank(car));
        }

        ImmutableCar bestCar = null;
        double bestScore = -1;
        for(Map.Entry<ImmutableCar, Double> entry : ranked.entrySet()){
            if(bestCar == null || entry.getValue() > bestScore){
                bestCar = entry.getKey();
                bestScore = entry.getValue();
            }
        }

        System.out.println("The best car is: " + bestCar);
    }
}
