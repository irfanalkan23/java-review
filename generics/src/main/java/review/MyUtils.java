package review;

import java.util.List;

public class MyUtils<T> {

    // Write a method that takes a list and prints each item in it and its total count.
    public void printInfo2(List<T> list) {

        for (T item : list) {
            System.out.println(item);
        }

        System.out.println(list.size());

    }

    // Write a method that takes a list and returns the last item of the list.
    public T getLastItem(List<T> list)  {
        return list.get(list.size() - 1);
    }

    // Write a method that takes a list and returns the last item name of the list. (Student, Teacher)
    // instanceof
    public String getLastItemName(List<T> list) throws Exception {

        T lastItem = list.get(list.size() - 1);

        if (lastItem instanceof Student) {
            return ((Student) lastItem).getName();
        } else if (lastItem instanceof Teacher) {
            return ((Teacher) lastItem).getName();
        } else {
            throw new Exception("Not a valid type");
        }

    }

}
