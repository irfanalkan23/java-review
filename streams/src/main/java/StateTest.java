import java.util.Arrays;
import java.util.List;

public class StateTest {

    public static void main(String[] args) {

        State va = new State();
        va.addCity("McLean");
        va.addCity("Arlington");
        va.addCity("Fairfax");
        va.addCity("FallsChurch");

        State tx= new State();
        tx.addCity("Dallas");
        tx.addCity("Plano");
        tx.addCity("Austin");
        tx.addCity("Houston");

        List<State> list = Arrays.asList(va,tx);

        //without flatMap. output in streams
        list.stream().map(State::getCities).forEach(System.out::println);

        //with flatMap. clean
        list.stream()
                .map(State::getCities)
                .flatMap(List::stream)
                .forEach(System.out::println);
        System.out.println("************");
        //with flatMap. less clean
        list.stream()
                .flatMap(state -> state.getCities().stream()).forEach(System.out::println);
    }
}
