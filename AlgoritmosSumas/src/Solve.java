
public class Solve {
    public static void main(String[] args) {
        int result = divide(4,0);
    }

    private static int divide(int a, int b) {
        int c = -1;
        try {
            c = a / b;
        } catch (Exception e) {
            System.err.println("Exception ");
        } finally {
            System.err.println("Finally ");
        }
        return c;

    }


}