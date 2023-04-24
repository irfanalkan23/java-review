package doublecolonoperator;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class CarTest {

    public static void main(String[] args) {

        //Zero-argument
        Supplier<Car> c1 = () -> new Car();    //referencing to constructor method (with no parameter)
        //Supplier : accept no parameter, return something. get() method.
        System.out.println("c1.get().getModel() = " + c1.get().getModel());

        Supplier<Car> c2 = Car::new;
        System.out.println("c2.get().getModel() = " + c2.get().getModel());

        //One-argument
        Function<Integer,Car> f1 = (model) -> new Car(model);
        Car bmw = f1.apply(2009);
        System.out.println("bmw.getModel() = " + bmw.getModel());

        Function<Integer,Car> f2 = Car::new;
        Car bmw2 = f2.apply(2015);
        System.out.println("bmw2.getModel() = " + bmw2.getModel());

        //Two-argument
        BiFunction<String,Integer,Car> b1 = (make,model) -> new Car(make,model);
        Car honda = b1.apply("Honda",2013);
        System.out.println(honda.getMake() + " " + honda.getModel());

        BiFunction<String,Integer,Car> b2 = Car::new;
        Car nissan = b2.apply("Nissan",2000);
        System.out.println(nissan.getMake() + " " + nissan.getModel());

    }
}
