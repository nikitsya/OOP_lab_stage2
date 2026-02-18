package t08_generics_1.exercises.ex04;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Exercise {

    public static <T> ArrayList<T> where(List<T> items, Predicate<T> predicate) {
        ArrayList<T> result = new ArrayList<>();

        if (predicate == null) {
            throw new NullPointerException("Predicate cannot be null");
        }

        if (items == null) {
            return result;
        }

        for (T item : items) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }

        return result;
    }

    public static void run() {

        List<String> strings = Exercise.where(
                List.of("Apple", "Garden", "Animal", "House", "Journey", "Planet", "Adventure"),
                s -> s.startsWith("A")
        );

        List<Integer> integers = Exercise.where(
                List.of(12, 2, 32, 4, 15, 16, 7, 81, 9, 10),
                i -> i > 10
        );

        System.out.println(strings);
        System.out.println(integers);
    }
}
