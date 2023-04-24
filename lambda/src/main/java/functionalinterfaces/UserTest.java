package functionalinterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class UserTest {

    public static void main(String[] args) {

        // Print all elements in the list

        List<User> users = new ArrayList<>();
        users.add(User.builder().firstName("Ali").lastName("Alkan").age(14).build());
        users.add(User.builder().firstName("Veli").lastName("Yanık").age(30).build());
        users.add(User.builder().firstName("Can").lastName("Eren").age(54).build());

        printName(users,p->true);   // (p)->true ==> this is the implementation

        System.out.println("------------------");

        // Print all users that last name starting with E
        printName(users,user->user.getLastName().startsWith("E"));
        // where does this "user.getLastName().startsWith("E")" go? ==> line 29 as boolean
    }

    private static void printName(List<User> users, Predicate<User> p){
        for (User user : users) {
            if (p.test(user)){
                System.out.println(user);
            }
        }
    }
}
