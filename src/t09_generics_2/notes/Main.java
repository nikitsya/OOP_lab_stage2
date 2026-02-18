package t09_generics_2.notes;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main() {
        demo();
    }

    /** This is PECS in practice: **/
    public static <T> void copy(List<? extends T> src, List<? super T> dst) {
        if (src == null || dst == null)
            throw new NullPointerException("src and dst must not be null");

        dst.addAll(src);
    }

    public static void demo() {
        List<Integer> src = List.of(1, 2, 3);

        List<Number> dst1 = new ArrayList<>();
        List<Object> dst2 = new ArrayList<>();

        copy(src, dst1); // Integer -> Number
        copy(src, dst2); // Integer -> Object
    }
}
