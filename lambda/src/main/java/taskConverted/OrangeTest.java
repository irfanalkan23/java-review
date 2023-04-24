package taskConverted;

import task.OrangeFormatter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class OrangeTest {

    public static void main(String[] args) {

        List<Orange> inventory = new ArrayList<>();
        inventory.add(new Orange(300, Color.GREEN));
        inventory.add(Orange.builder().weight(200).color(Color.GREEN).build());
        inventory.add(Orange.builder().weight(100).color(Color.RED).build());
        inventory.add(Orange.builder().weight(500).color(Color.RED).build());
        inventory.add(Orange.builder().weight(300).color(Color.GREEN).build());

        //instead of the middle layer (simpleFormatter interface), we can put action directly here;
        //advantage of lambda expression; we can pass the action directly
        Function<Orange,String> simpleFormatter = (Orange orange) -> "An orange of " + orange.getWeight() + "g";
        prettyPrintOrange(inventory,simpleFormatter);

        System.out.println("*************");
        //we can simplify: pass the action directly to the method as a behavior!
        prettyPrintOrange(inventory,orange -> "An orange of " + orange.getWeight() + "g");

        System.out.println("***********************");

        Function<Orange,String> fancyFormatter = orange -> {
            String characteristic = orange.getWeight() > 150 ? "Heavy" : "Light";
            return "A " + characteristic + " " + orange.getColor() + " orange";
        };

        prettyPrintOrange(inventory,fancyFormatter);    //behaviour: fancyFormatter

        System.out.println("***");
        prettyPrintOrange(inventory, orange -> {
            String characteristic = orange.getWeight() > 150 ? "Heavy" : "Light";
            return "A " + characteristic + " " + orange.getColor() + " orange";
        });

    }

    // Task: convert into functional interface: ==> taskConverted package
    private static void prettyPrintOrange(List<Orange> inventory, Function<Orange,String> orangeFunction){
        for (Orange orange : inventory) {
            String output = orangeFunction.apply(orange);
            System.out.println(output);
        }
    }
}
