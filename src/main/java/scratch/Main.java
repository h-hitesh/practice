package scratch;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.checkFinally());
    }

    public int checkFinally() {
        try {
            int i = 5 * 2;
            int j = 5/0;
            return 9;
        } catch (ArithmeticException e) {
            return 0;
        } finally {
            return 5;
        }
    }
}
