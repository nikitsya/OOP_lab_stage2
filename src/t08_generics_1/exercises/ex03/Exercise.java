package t08_generics_1.exercises.ex03;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


public class Exercise {

    public static <T, R> ArrayList<R> map(List<T> items, Function<T, R> transform) {

        ArrayList<R> result = new ArrayList<>();

        if (transform == null) {
            throw new NullPointerException("transform is null");
        }

        if (items == null) {
            return result;
        }

        for (T item : items) {
            result.add(transform.apply(item));
        }

        return result;
    }

    public static void run() {
        ArrayList<Integer> lengths = Exercise.map(List.of("ant", "zebra"), String::length);
        ArrayList<String> labels = Exercise.map(List.of(10, 20), n -> "HP:" + n);

        System.out.println(lengths);
        System.out.println(labels);
    }
}
