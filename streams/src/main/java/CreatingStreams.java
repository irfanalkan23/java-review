import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CreatingStreams {

    public static void main(String[] args) {

        //Creating Stream from Array. not common way.
        String[] courses = {"Java","JS","TS"};
        Stream<String> courseStream = Arrays.stream(courses);

        //Creating Stream from Collection. commonly used way.
        List<String> courseList = Arrays.asList("Java","JS","TS");
        Stream<String> courseStream2 = courseList.stream();

        List<Course> myCourses = Arrays.asList(
                new Course("Java",100),
                new Course("DS",101),
                new Course("Spring",102),
                new Course("Microservices",103)
        );

        Stream<Course> myCourseStream = myCourses.stream();

        //Creating Stream from Values. not common way
        Stream<Integer> stream = Stream.of(1,2,3,4);
    }
}
