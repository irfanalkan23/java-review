package doublecolonoperator;

public class Calculator {

    // static method
    public static void findSum(int x, int y){
        System.out.println("Sum " + (x+y));
    }

    // instance method
    public void findMultiply(int x, int y){
        System.out.println("Multiply " + (x*y));
    }
}
