package leetcode.problems;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Given an array of unique integers, arr, where each integer arr[i] is strictly greater than 1.
 * <p>
 * We make a binary tree using these integers, and each number may be used for any number of times.
 * Each non-leaf node's value should be equal to the product of the values of its children.
 * <p>
 * Return the number of binary trees we can make. The answer may be too large so return the answer modulo 109 + 7.
 */
public class BinaryTreesWithFactors {

    public static final double MOD = Math.pow(10, 9) + 7;

    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        Map<Long, Long> subTrees = new TreeMap<>();
        subTrees.put(((long) arr[0]), 1L);
        for (int i = 1; i < arr.length; i++) {
            long root = arr[i];
            subTrees.put(root, 1L);
            for (int j = 0; j < i; j++) {
                long lc = arr[j];
                if (root % lc == 0) {
                    subTrees.computeIfPresent(root, (k, v) -> v + (subTrees.get(lc) * subTrees.getOrDefault(root / lc, 0L)));
                }
            }
        }
        return (int) (subTrees.values().stream().mapToLong(i -> i).sum() % MOD);
    }

    static final int modulo = 1000000000 + 7;

    public int numFactoredBinaryTrees_fast(int[] arr) {
        Arrays.sort(arr); // ensures children[i].{first,second} < i
        final var n = arr.length;
        // time O(n^2), space = O(n) [and clobbers input array, O(n)]
        final var maxv = arr[n - 1];
        final var dp = new int[n];
        Arrays.fill(dp, 1);
        for (var i = 0; i < n; i++) {
            final var arr_i = arr[i];
            final var limit = Math.min(maxv / arr_i, arr_i);
            var k = i + 1;
            // note: for i == n - 1, k = n,
            // but it won't ever be dereferenced, as limit = 1 < arr[0]
            final var dpi = dp[i];
            for (var j = 0; ; j++) {
                final var arr_j = arr[j];
                if (arr_j > limit) break;
                final var x = arr_i * arr_j; // <= maxv, won't overflow
                while (arr[k] < x) // ammortized time = O(1)
                    ++k;
                if (/*k == n ||*/ arr[k] != x)
                    // x <= maxv, hence k != n
                    continue;
                var cc = (int) (((long) dpi) * dp[j] % modulo);
                if (i != j) {
                    cc += cc;
                    if (cc >= modulo) cc -= modulo;
                }
                cc += dp[k];
                if (cc >= modulo) cc -= modulo;
                dp[k] = cc;
            }
        }
        var ret = 0;
        for (var dpi : dp) {
            ret += dpi;
            if (ret >= modulo) ret -= modulo;
        }
        return ret;
    }
}
