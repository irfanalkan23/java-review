package review;

import java.util.ArrayList;
import java.util.List;

public class CarTest {

    public static void main(String[] args) {

        List<Car> carList = new ArrayList<>();

        carList.add(new Car("Toyota", 140, 1998));
        carList.add(new Car("Audi", 200, 2008));
        carList.add(new Car("BMW", 210, 2020));
        carList.add(new Car("Nissan", 150, 2018));

        System.out.println("List of fast cars:");
        System.out.println(filterFastCars(carList));
        System.out.println("List of new cars:");
        System.out.println(filterNewCars(carList));

        System.out.println("-------------------");

        System.out.println("List of fast cars:");
        System.out.println(filter(carList, new CarFastPredicate()));
        System.out.println("List of new cars:");
        System.out.println(filter(carList, new CarNewPredicate()));

        // Durable car, if a car is Toyota, it is durable.
        System.out.println("List of durable cars:");
        System.out.println(filter(carList, new CarDurablePredicate()));

        System.out.println("-------------------");

        // Functional Programming - Function = Method
        // ->    Fat Arrow

        CarPredicate newCarLambda = car -> car.getYear() > 2015;
        List<Car> newCars = filter(carList, newCarLambda);
        System.out.println("New Cars: " + newCars);

        List<Car> fastCars = filter(carList, car -> car.getTopSpeed() > 160);
        System.out.println("Fast Cars: " + fastCars);

        carList.forEach(System.out::println);
        carList.forEach(Car::getMake);
        carList.forEach(car -> System.out.println(car.getMake()));      //  First, get the make info. Second, print it
//        System.out.println(carList.forEach(Car::getMake));    // Error

//        List<Car> anotherList = new ArrayList<>();

//        carList.forEach(car -> {
//            if (car.getYear() > 2005) anotherList.add(car);
//        });
//
//        carList.forEach(car -> {
//            if (car.getYear() > 2005) anotherList::add;
//        });

    }

    private static List<Car> filterFastCars(List<Car> cars) {

        List<Car> filteredCars = new ArrayList<>();

        for (Car car : cars) {
            if (car.getTopSpeed() > 160) {
                filteredCars.add(car);
            }
        }

        return filteredCars;

    }

    private static List<Car> filterNewCars(List<Car> cars) {

        List<Car> filteredCars = new ArrayList<>();

        for (Car car : cars) {
            if (car.getYear() > 2015) {
                filteredCars.add(car);
            }
        }

        return filteredCars;

    }

    private static List<Car> filter(List<Car> cars, CarPredicate carPredicate) {

        List<Car> filteredCars = new ArrayList<>();

        for (Car car : cars) {
            if (carPredicate.test(car)) {
                filteredCars.add(car);
            }
        }

        return filteredCars;

    }

}