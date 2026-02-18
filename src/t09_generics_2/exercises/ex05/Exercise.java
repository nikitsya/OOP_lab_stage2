package t09_generics_2.exercises.ex05;

import java.util.ArrayList;
import java.util.List;

public class Exercise {

    public static <T> void copy(List<? extends T> src, List<? super T> dst) {
        if (src == null || dst == null) {
            throw new IllegalArgumentException("src or dst is null");
        }
        dst.addAll(src);
    }

    public static void run() {
        List<Integer> src = List.of(1, 2, 3);

        List<Object> dst1 = new ArrayList<>(List.of(4, 5, 6));
        List<Number> dst2 = new ArrayList<>(List.of(4, 5, 6));

        copy(src, dst1);
        copy(src, dst2);

        System.out.println(dst1);
        System.out.println(dst2);
    }
}