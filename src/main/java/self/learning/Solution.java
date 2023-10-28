package self.learning;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Long> freq = new Hashtable<>();
//        Map<Integer, Integer> f = new Hashtable<>();
        queries.forEach(l -> {
            int op = l.get(0);
            int val = l.get(1);
            if (1 == op) {
                if (freq.containsKey(val)) {
                    freq.put(val, freq.get(val) +1);
                } else {
                    freq.put(val, 1L);
                }
//                freq.put(val, freq.getOrDefault(val, 0L) + 1);
            } else if (2 == op) {
                if (freq.containsKey(val)) {
                    freq.computeIfPresent(val, (k, v) -> v == 0 ? null : v - 1);
                }
            } else if (op == 3) {
                res.add((freq.values().stream().anyMatch(v -> v == val)) ? 1 : 0);
            }
        });

        return res;
    }

    public static void main(String[] args) throws IOException {
        List<List<Integer>> queries = new ArrayList<>();
        FileReader fileReader = new FileReader("C:\\Users\\hemah\\IdeaProjects\\ScratchPad\\src\\main\\resources\\ip.txt");
        Scanner scanner = new Scanner(fileReader);
        while (true) {
            try {
                String s = scanner.nextLine();
                if (s.isEmpty()) break;
                queries.add(Stream.of(s.trim().split(" ")).map(Integer::parseInt).collect(toList()));
            } catch (Exception e) {
                break;
            }
        }
        long start = System.nanoTime();
        List<Integer> integers = freqQuery(queries);
        long end = System.nanoTime();
        double elapsedTimeInSecond = (double) (end - start) / 1_000_000_000;
        System.out.println(elapsedTimeInSecond + " seconds");
//        System.out.println(integers);
    }
}
