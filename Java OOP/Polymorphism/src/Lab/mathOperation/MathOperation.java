package Lab.mathOperation;

public class MathOperation {


    private MathOperation() {} //Without the private constructor for Judge


    public static int add(int a, int b) {
        return a + b;
    }

    public static int add(int a, int b, int c) {
        return add(a, add(b, c));
    }

    public static int add(int a, int b, int c, int d) {
        return add(a, add(b, c, d));
    }
}
