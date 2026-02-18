package t08_generics_1.notes;

import java.util.List;
import static java.util.Collections.max;


public class Main {

    static void main() {
        // stepA();
        // stepB();
        // stepC();

    }

    private static void stepA() {
        // Start with the problem: Object storage
        BoxObject box = new BoxObject("hi");

        // safe cast (because we happen to know it's a String)
        String s = (String) box.value();

        // unsafe cast (compiles, may crash)
        Integer n = (Integer) box.value();
    }

    private static void stepB() {
        // Replace with a generic container
        Box<String> a = new Box<>("hi");
        Box<Integer> b = new Box<>(42);

        // No casts needed:
        System.out.println(a.value().toUpperCase());
        System.out.println(b.value() + 1);
    }

    private static void stepC() {
        // Step C — Write a generic algorithm with a constraint
        List<Integer> numbers = List.of(10, 3, 25);
        System.out.println(max(numbers)); // 25

        List<String> words = List.of("ant", "zebra", "cat");
        System.out.println(max(words)); // zebra (lexicographic)
    }

    // Quick “require not null” helper (reuses Java’s standard exception)
    public static <T> T requireNotNull(T value, String message) {
        if (value == null)
            throw new NullPointerException(message);
        return value;
    }

    // Generic swap for arrays (note: arrays are reifiable; generics are erased)
    public static <T> void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
