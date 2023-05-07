package functionalinterfaces;

import java.util.function.*;

public class Examples {

    public static void main(String[] args) {

        //PREDICATE
        Predicate<Integer> lesserThan = a -> a < 8;
        // = implementation of test method
        // = public boolean abc(Integer a){ return a < 18; }
        // lambda doesn't belong to any class ==> no need for public
        // compiler understands return type ==> no need for boolean
        // how do we call the method? with the action name "lesserThan" ==> delete method name abc
        // Type Inference ==> delete Integer
        // result ==> = a -> a < 8;

        // a -> a < 8; this lambda expression means what ? ==> "implementation of test() method !!!

        Boolean result = lesserThan.test(50);
        System.out.println("result = " + result);

        //CONSUMER
        Consumer<Integer> display = i -> System.out.println(i);
        display.accept(50);

        //BICONSUMER
        BiConsumer<Integer,Integer> addTwo = (x,y) -> System.out.println(x+y);
        addTwo.accept(100,200);

        //FUNCTION
        Function<String,String> fun = s -> "Hello " + s;
        String str = fun.apply("Ozzy");
        System.out.println(str);

        //SUPPLIER: no parameter, returns something
        Supplier<Double> randomNumber = () -> Math.random();
        System.out.println("randomNumber.get() = " + randomNumber.get());

    }
}
