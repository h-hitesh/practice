package leetcode.problems;

public class KthSymbolInGrammar {
    public static void main(String[] args) {
        KthSymbolInGrammar symbolInGrammar = new KthSymbolInGrammar();
        int i = symbolInGrammar.kthGrammar(30, 434991989);
        System.out.println("out: " + i);
    }

    public int kthGrammar(int N, int K) {

        // Base case
        if (N == 1 && K == 1) {
            return 0;
        }

        // If K is even, it is in the second half of the previous row
        if (K % 2 == 0) {
            return (1 - kthGrammar(N-1, K/2));
        }

        // If K is odd, it is in the first half of the previous row
        else {
            return kthGrammar(N-1, (K+1)/2);
        }
    }
}
