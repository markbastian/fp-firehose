package cars2;

public class TestDriver2 {
    //Super complicated ranking function.
    public static double rank(IColorData car){
        double score = 0.0;
        switch (car.getColor()) {
            case "Red":
                score = 2.0;
                break;
            case "Green":
                score = 1.0;
                break;
            case "White":
                score = 1.5;
                break;
            case "Black":
                score = 1.9;
                break;
            case "Beige":
                score = 0.0;
                break;
        }
        return score;
    }
}
