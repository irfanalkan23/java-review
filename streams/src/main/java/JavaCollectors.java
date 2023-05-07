import dishtask.Dish;
import dishtask.DishData;
import dishtask.Type;

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

        System.out.println("numberList = " + numberList);   //[4, 6, 6]

        Set<Integer> numberSet = numbers.stream()
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toCollection(HashSet::new));

        System.out.println("numberSet = " + numberSet); //output: [4, 6] --> no duplicates (Set)!

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

        //toMap(Function, Function) : WE MAY USE IT!
        //returns a Collector interface that gathers the input data into a new map
        Map<String, Integer> dishMap = DishData.getAll().stream()
                //Key=Dish name, Value=Calories
                .collect(Collectors.toMap(Dish::getName, Dish::getCalories));

        System.out.println("dishMap = " + dishMap);

        System.out.println("---- counting() -----");

        //counting(): returns a Collector that counts the number of elements (we don't use)
        Long evenCount = numbers.stream()
                .filter(x -> x % 2 == 0)
                .collect(Collectors.counting());

        System.out.println("evenCount = " + evenCount);

        System.out.println("---- summingInt() -----");

        //summingInt(ToIntFunction): returns a Collector that produces the sum of a integer-valued function
        Integer sum = DishData.getAll().stream()
                .collect(Collectors.summingInt(Dish::getCalories));

        System.out.println("sum = " + sum);

        System.out.println("---- averagingInt() -----");

        //averagingInt(ToIntFunction): returns the average of the integers passed values
        Double calorieAvg = DishData.getAll().stream()
                .collect(Collectors.averagingInt(Dish::getCalories));

        System.out.println("calorieAvg = " + calorieAvg);

        System.out.println("---- joining() -----");

        //joining(): is used to join various elements of a character or string array into a single string object
        List<String> courses = Arrays.asList("Java", "JS", "TS");
        String str = courses.stream()
                .collect(Collectors.joining(","));

        System.out.println("str = " + str);

        System.out.println("---- partitioningBy() -----");

        //partitioningBy(): is used to partition a stream of objects (or set of elements) based on a given predicate
        Map<Boolean, List<Dish>> veggieDish = DishData.getAll().stream()
                .collect(Collectors.partitioningBy(Dish::isVegetarian));

        System.out.println(veggieDish);
        //Output:
        // {false=
        // [Dish(name=pork, vegetarian=false, calories=800, type=MEAT),
        // Dish(name=beef, vegetarian=false, calories=700, type=MEAT),
        // Dish(name=chicken, vegetarian=false, calories=400, type=MEAT),
        // Dish(name=shrimp, vegetarian=false, calories=300, type=FISH),
        // Dish(name=salmon, vegetarian=false, calories=450, type=FISH)],
        // true=
        // [Dish(name=french fries, vegetarian=true, calories=530, type=OTHER),
        // Dish(name=rice, vegetarian=true, calories=350, type=OTHER),
        // Dish(name=season fruit, vegetarian=true, calories=120, type=OTHER)]}

        System.out.println("---- groupingBy() -----");

        //groupingBy(): is used for grouping objects by some property and storing results in a map instance
        Map<Type, List<Dish>> dishType = DishData.getAll().stream()
                .collect(Collectors.groupingBy(Dish::getType));

        //What is the difference bw partitioningBy() and groupingBy() ?
        // partitioningBy() --> gets a predicate, and groups as boolean (true/false)
        // groupingBy() --> groups by the criteria that we decide

        System.out.println("dishType = " + dishType);

        //Output:
        // {OTHER=
        // [Dish(name=french fries, vegetarian=true, calories=530, type=OTHER),
        // Dish(name=rice, vegetarian=true, calories=350, type=OTHER),
        // Dish(name=season fruit, vegetarian=true, calories=120, type=OTHER)],
        // MEAT=
        // [Dish(name=pork, vegetarian=false, calories=800, type=MEAT),
        // Dish(name=beef, vegetarian=false, calories=700, type=MEAT),
        // Dish(name=chicken, vegetarian=false, calories=400, type=MEAT)],
        // FISH=
        // [Dish(name=shrimp, vegetarian=false, calories=300, type=FISH),
        // Dish(name=salmon, vegetarian=false, calories=450, type=FISH)]}.

    }
}
