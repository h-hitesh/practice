package self.learning.dsa.queue;

import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Priority {
    public static void main(String[] args) {
//        Comparator.comparingInt((f,s) -> f > s ?  )
        Set<Integer> set = new HashSet<>();
        long start = System.nanoTime();
        for (int i = 1_00_00_000; i > 0; i--) {
            set.add(i);
        }
        long end = System.nanoTime();
        long convert = TimeUnit.SECONDS.convert(end - start, TimeUnit.NANOSECONDS);
        System.out.println("Took: " + convert + " seconds");
//        System.out.println(set);

    }
}
