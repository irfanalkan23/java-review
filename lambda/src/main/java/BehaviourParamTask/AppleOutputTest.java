package BehaviourParamTask;

import java.util.ArrayList;
import java.util.List;

public class AppleOutputTest {

    /* Task:
Write a prettyPrintApple method that takes aList of Apples and that can be parameterized with multiple ways to generate a String output from an apple

public static void prettyPrintApple(List<Apple> inventory, ???){
    for(Apple apple : inventory){
        String output = ???.???(apple);
        System.out.println(output);
    }
}

Sample Output :			Sample Output :
A Light GREEN apple			An apple of 80g
A Heavy RED apple			An apple of 155g
A Light GREEN apple			An apple of 120g
     */

    public static void main(String[] args) {

        List<Apple> inventory = new ArrayList<>();
        inventory.add(new Apple(300,Color.GREEN));
        inventory.add(new Apple(200,Color.GREEN));
        inventory.add(new Apple(100,Color.RED));
        inventory.add(new Apple(500,Color.RED));
        inventory.add(new Apple(300,Color.GREEN));

        prettyPrintApple(inventory, new AppleOutputFancyFormatter());
        System.out.println("****************");
        prettyPrintApple(inventory, new AppleOutputSimpleFormatter());

    }

    public static void prettyPrintApple(List<Apple> inventory, AppleOutputFormatter appleOutputFormatter){
        for(Apple apple : inventory){
            String output = appleOutputFormatter.output(apple);
            System.out.println(output);
        }
    }

}
