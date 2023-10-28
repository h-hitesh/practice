package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeating {
    public static void main(String[] args) {
        LongestSubStringWithoutRepeating l = new LongestSubStringWithoutRepeating();
        int i = l.lengthOfLongestSubstring("bb");
        System.out.println("Res-" + i);

    }

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        max = Math.max(max, count(s, 0, max));
        return max;
    }


    private int count(String s, int start, int max) {
        int len = 0;
        Set<Character> set = new HashSet<>();
        int index = start;
        while (index < s.length()) {
            char x = s.charAt(index);
            if (set.contains(x)) {
                max = Math.max(max, count(s, start + 1, Math.max(len, max)));
                break;
            } else {
                set.add(x);
                index++;
                len++;
            }
        }
        return Math.max(len, max);
    }
}
