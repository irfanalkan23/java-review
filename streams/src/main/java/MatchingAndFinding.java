import dishtask.Dish;
import dishtask.DishData;

import java.util.Optional;

public class MatchingAndFinding {

    public static void main(String[] args) {

        //allMatch()
        boolean isHealthy = DishData.getAll().stream().allMatch(dish -> dish.getCalories() < 1000);
        System.out.println("isHealthy = " + isHealthy);

        System.out.println("******* anyMatch()*******");
        //anyMatch()
        if(DishData.getAll().stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu is vegetarian friendly");
        }

        System.out.println("******* noneMatch() *******");
        //noneMatch()
        boolean isHealthy2 = DishData.getAll().stream().noneMatch(dish -> dish.getCalories() >= 1000);
        System.out.println("isHealthy2 = " + isHealthy2);

        System.out.println("******* findAny() *******");
        //findAny()
        Optional<Dish> dish = DishData.getAll().stream()
                .filter(Dish::isVegetarian)
                .findAny();
        System.out.println("dish = " + dish.get());

        System.out.println("******* findFirst() *******");
        //findFirst()
        Optional<Dish> dish2 = DishData.getAll().stream()
                .filter(Dish::isVegetarian)
                .findFirst();
        System.out.println("dish = " + dish2.get());

    }
}
