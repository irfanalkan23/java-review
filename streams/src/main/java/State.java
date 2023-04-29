import java.util.ArrayList;
import java.util.List;

public class State {
    /*
    TASK
Suppose we have a State class that contains list of cities. Create a list
of States and print all the cities.
        public class State {
         private List<String> cities = new ArrayList<>();
         public void addCity(String city){
         cities.add(city);
         }
         public List<String> getCities(){
         return this.cities;
         }
        }
     */

    private List<String> cities = new ArrayList<>();

    public void addCity(String city){
        cities.add(city);
    }
    public List<String> getCities(){
        return this.cities;
    }
}
