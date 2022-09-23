package codingtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class JustTest {
    public static void main(String[] args) {
        List<String> objects = Arrays.asList("Apple","Bear","Car","Desk");
        System.out.println(objects);
        objects.stream();
        System.out.println(objects);

        Stream<String> a = objects.stream().filter(x -> x.contains("e"));
        System.out.println();
        a.forEach((s -> {
            System.out.print(s+" ");
        }));

        System.out.println("\n\n");
        objects.parallelStream()
                .map(x -> x.concat("s"))
                .forEach(x -> System.out.println(x));

        List<Integer> nums = Arrays.asList(1, 2324, 2, 34);
        nums.parallelStream()
                .map(x -> x*2)
                .forEach(x -> System.out.println(x));

        //List<Integer>  ages = new ArrayList<Integer>();
        //ages.add(1);ages.add(2);ages.add(3);//1,2,3
        //System.out.println(ages.stream().reduce((b,c) -> b+c).get());//1+2+3=6
//        List<Integer> ages = new ArrayList<Integer>();
//        ages.add(1);ages.add(2);ages.add(3);ages.add(4);
//        System.out.println("\n\n");
//        System.out.println(ages.stream().reduce((b,c) -> b+c).get());




    }
}
