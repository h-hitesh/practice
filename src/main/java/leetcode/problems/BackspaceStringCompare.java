package leetcode.problems;

import java.util.Stack;

public class BackspaceStringCompare {
    public static void main(String[] args) {
        String s = "y#fo##f";
        String t = "y#f#o##f";

        BackspaceStringCompare backspaceStringCompare = new BackspaceStringCompare();
        backspaceStringCompare.backspaceCompare(s, t);
    }

    public boolean backspaceCompare(String s, String t) {
        Stack<Character> ss = new Stack<>();
        Stack<Character> ts = new Stack<>();
        compute(s, ss);
        compute(t, ts);
        return convertStackToString(ss).equals(convertStackToString(ts));
    }

    private static String convertStackToString(Stack<Character> ss) {
        StringBuilder sb = new StringBuilder();
        ss.forEach(sb::append);
        System.out.println(ss + " -> " + sb);
        return sb.toString();
    }

    private static void compute(String s, Stack<Character> ss) {
        s.chars().mapToObj(c -> (char) c).forEach(c -> {
            if (c == '#') {
                try {
                    ss.pop();
                } catch (Exception ignore) {
                }
            } else {
                ss.push(c);
            }
        });
    }
}
