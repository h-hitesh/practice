package hackerrank;

import java.util.Scanner;

public class RegexExample {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }

    }

    static class MyRegex {
        public static String pattern = "([0-9]{0,3}\\.*){4}";
    }
}
