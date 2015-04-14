package j8;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class J8Map {
    public static void main(String[] args){
        List<Integer> ints = new LinkedList<>();
        for(int i = 0; i < 1000000; i++) ints.add(i);

        List<Integer> squares =
                ints.stream().map(i -> i * i).collect(Collectors.toList());
        
        System.out.println(squares.size());
    }
}
