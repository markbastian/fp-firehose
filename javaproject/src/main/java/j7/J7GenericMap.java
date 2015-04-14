package j7;

import java.util.LinkedList;
import java.util.List;

public class J7GenericMap {
    public interface IOperation<T, U> {
        public T apply(U input);
    }

    public static <T, U> List<T> map(List<U> input, IOperation<T, U> operation){
        List<T> output = new LinkedList<T>();
        for(U i : input){
            output.add(operation.apply(i));
        }
        return output;
    }

    public static void main(String[] args){
        List<Integer> ints = new LinkedList<Integer>();
        for(int i = 0; i < 1000000; i++) ints.add(i);

        //Java is so wonderful because the syntax is so simple
        List<Double> squares = map(ints, new IOperation<Double, Integer>() {
            @Override
            public Double apply(Integer input) {
                return Math.sqrt(input);
            }
        });

        System.out.println(squares.size());
    }
}
