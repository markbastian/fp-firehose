package cars;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CarPurchasingModel {
    public static void main(String[] args){
        List<String> colors = new LinkedList<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("White");
        colors.add("Black");
        colors.add("Beige");
        
        Map<Car, Double> ranked = new HashMap<Car, Double>();
        for(String color : colors){
            Car car = new Car();
            car.setColor(color);
            car.setMake("Honda");
            car.setYear(2015);
            car.setColor(color);
            car.setTopSpeed(120.0);
            ranked.put(car, TestDriver.rank(car));
        }
        
        Car bestCar = null;
        double bestScore = -1;
        for(Map.Entry<Car, Double> entry : ranked.entrySet()){
            if(bestCar == null || entry.getValue() > bestScore){
                bestCar = entry.getKey();
                bestScore = entry.getValue();
            }
        }
        
        System.out.println("The best car is: " + bestCar);
    }
}
