import dishtask.DishData;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Reducing {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(4,5,3,9);
        int result = numbers.stream().reduce(0,(a,b) -> a+b);
        System.out.println("result = " + result);

        Optional<Integer> result2 = numbers.stream().reduce((a, b) -> a + b);
        System.out.println("result2 = " + result2);

        //max() and min()
        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        Optional<Integer> sum = numbers.stream().reduce(Integer::sum);

        System.out.println("min = " + min);
        System.out.println("max = " + max);
        System.out.println("sum = " + sum);

        //TASK
        //How would you count the number of dishes in a stream using the
        // "map and reduce" methods?
        int count = DishData.getAll().stream()
                .map(dish -> 1)
                .reduce(0, (a, b) -> a+b);
        System.out.println("count = " + count);

        // stream().count() method
        long count2 = DishData.getAll().stream().count();
        System.out.println("count2 = " + count2);

        // Collection.size() method
        long count3 = DishData.getAll().size();
        System.out.println("count3 = " + count3);

    }
}
