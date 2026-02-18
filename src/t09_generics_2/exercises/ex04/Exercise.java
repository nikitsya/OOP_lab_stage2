package t09_generics_2.exercises.ex04;

import java.util.ArrayList;
import java.util.List;

public class Exercise {

    public static <T> void fill(List<? super T> out, T value, int count) {
        if (out == null) throw new NullPointerException("Out is null");
        if (count < 0) throw new IndexOutOfBoundsException("Count is negative");
        if (count == 0) return;

        for (int i = 0; i < count; i++) {
            out.add(value);
        }
    }

    public static void run() {
        List<Object> out = new ArrayList<>(); fill(out, "hi", 3);
        List<Number> out2 = new ArrayList<>(); fill(out2, 5, 2);

        System.out.println(out);
        System.out.println(out2);
    }
}
