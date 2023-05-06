package employeepractice;

import java.util.Collection;
import java.util.List;

public class EmployeeTest {

    public static void main(String[] args) {

        //Print all emails. One employee has one email --> One to One
        EmployeeData.readAll()
                .map(Employee::getEmpEmail)
                .forEach(System.out::println);

        System.out.println("------ phone numbers (map) ------");

        //Print all phone numbers
        EmployeeData.readAll()
                .map(Employee::getEmpPhoneNumbers)
                .forEach(System.out::println);
        /*Output:
        [2029124536, 2023464768]
        [7039124536, 7033464768]
        [5169124536, 5163464768]
        */

        System.out.println("------ phone numbers (flatMap) ------");
        EmployeeData.readAll()
                .flatMap(employee -> employee.getEmpPhoneNumbers().stream())
                .forEach(System.out::println);
        /*
        2029124536
        2023464768
        7039124536
        7033464768
        5169124536
        5163464768
         */

        System.out.println("------ phone numbers (flatMap) cleaner ------");

        EmployeeData.readAll()
                .map(Employee::getEmpPhoneNumbers)
                .flatMap(List::stream)
                .forEach(System.out::println);



    }
}
