package gfg;

import java.util.*;

public class FactorialForLargeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        ArrayList<Integer> factorial = factorial(i);
        System.out.println(factorial);

    }

    private static ArrayList<Integer> factorial(int N) {
        int fact = fact(N);
        System.out.println();
        ArrayList<Integer> integers = new ArrayList<>();
        convertToList(fact, integers);
        return integers;
    }

    private static void convertToList(int n, List<Integer> list) {
        Map<String, Integer> m = new HashMap<>();
    }


    private static int fact(int n) {
        System.out.print(n);
        if (n > 1) {
            System.out.print("x");
            return n * fact(n - 1);
        }
        return 1;
    }
}
