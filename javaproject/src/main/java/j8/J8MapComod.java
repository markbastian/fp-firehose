package j8;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class J8MapComod {
    public static void main(String[] args){
        List<Integer> ints = new LinkedList<>();
        for(int i = 0; i < 1000000; i++) ints.add(i);

        new Thread(() -> {
            while(!ints.isEmpty()) ints.remove(0);
        }).start();

        List<Integer> evens =
                ints.stream().filter(i -> (0 == (i % 2))).collect(Collectors.toList());

        System.out.println(evens.size());
    }
}
