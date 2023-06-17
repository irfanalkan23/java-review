package review;

public class CarDurablePredicate implements CarPredicate {
    @Override
    public boolean test(Car car) {
        return car.getMake().equalsIgnoreCase("toyota");
    }
}