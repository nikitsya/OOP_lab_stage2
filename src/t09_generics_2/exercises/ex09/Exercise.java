package t09_generics_2.exercises.ex09;

import java.util.ArrayList;
import java.util.List;

public class Exercise {

    public static void swapFirstTwo(List<?> items) {
        if (items == null || items.size() < 2) return;
        swapFirstTwoCaptured(items);

    }

    private static <T> void swapFirstTwoCaptured(List<T> items) {
        T first = items.get(0);
        T second = items.get(1);
        items.set(0, second);
        items.set(1, first);
    }

    public static void run() {
        List<String> strings = new ArrayList<>(List.of("a", "b", "c"));
        List<Integer> integers = new ArrayList<>(List.of(1, 2, 3));

        for (String s : strings) System.out.println(s); System.out.println();
        for (Integer i : integers) System.out.println(i); System.out.println();

        swapFirstTwo(strings);
        swapFirstTwo(integers);

        for (String s : strings) System.out.println(s); System.out.println();
        for (Integer i : integers) System.out.println(i);
    }
}
