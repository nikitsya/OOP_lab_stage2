package t09_generics_2.exercises.ex11;

import java.util.List;

public class Exercise {

    public static <T> void merge(List<? extends T> a, List<? extends T> b, List<? super T> out) {
        if (out == null) throw new NullPointerException();
        if (a != null) out.addAll(a);
        if (b != null) out.addAll(b);
    }

    public static void run() {
        java.util.List<Integer> a = java.util.List.of(1, 2);
        java.util.List<Integer> b = java.util.List.of(3);

        java.util.ArrayList<Number> out = new java.util.ArrayList<>();
        merge(a, b, out);

        System.out.println(out);
    }
}
