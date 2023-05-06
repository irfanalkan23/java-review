import java.util.*;
import java.util.stream.Collectors;

public class JavaCollectors {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(3,4,5,6,6,7);

        System.out.println("------ toCollection() -------");

        //toCollection(Supplier): WE DON'T USE! -- is used to create a collection using Collector
        List<Integer> numberList = numbers.stream()
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.println("numberList = " + numberList);

        Set<Integer> numberSet = numbers.stream()
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toCollection(HashSet::new));

        System.out.println("numberSet = " + numberSet);

        System.out.println("------ toList() -----");

        //toList() : WE ALWAYS USE THIS! --
        // returns a Collector interface that gathers the input data into a new list
        List<Integer> numbersList2 = numbers.stream()
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());

        System.out.println("numbersList2 = " + numbersList2);

        System.out.println("------ toSet() -------");

        //toSet() : returns a Collector interface that gathers the input date into a new set
        Set<Integer> numbersSet2 = numbers.stream()
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toSet());

        System.out.println("numbersSet2 = " + numbersSet2);

        System.out.println("---- toMap() -----");

        //toMap(Function, Function) : returns a Collector interface that gathers the input data into a new map



    }
}
