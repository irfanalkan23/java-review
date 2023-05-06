import java.util.Arrays;
import java.util.List;

public class StreamOperations {

    public static void main(String[] args) {

        List<Integer> myList = Arrays.asList(1,2,3,4,4,3,4,5,6,2,9);
        myList.forEach(System.out::println);    //this forEach() is from Iterable interface

        System.out.println("---------filter()-------------");

        //filter(Predicate<T>)
        myList.stream()
                .filter(i -> i%3==0)
                .distinct()
                .forEach(System.out::println);  //this forEach() is from Stream interface

        System.out.println("---------filter()-------------");

        //limit()
        myList.stream()
                .filter(i->i%2==0)
                .limit(1)
                .forEach(System.out::println);

        System.out.println("---------skip()-------------");

        //skip()
        myList.stream()
                .filter(i->i%2==0)
                .skip(1)
                .forEach(System.out::println);

        System.out.println("---------map()-------------");

        //map()
        myList.stream()
                .map(number->number*2)
                .filter(i->i%3==0)
                .forEach(System.out::println);

        System.out.println("---------Task: print the number of characters for each word-------------");

        //TASK
        //Given a list of words, print the number of characters for each word.
        List<String> words = Arrays.asList("JAVA","APPLE","HONDA","DEVELOPER");
        words.stream()
                .map(String::length)
                .forEach(System.out::println);

    }
}
