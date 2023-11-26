package edu.hw7;

import java.util.ArrayList;
import java.util.stream.IntStream;

public final class Task2 {
    private Task2() {
    }

    public static int getFactParal(int n) {
        if (n < 2) {
            return 1;
        }

        return IntStream.rangeClosed(2, n).parallel().boxed()
            .reduce((Integer a, Integer b) -> a*b).get();
    }
}
