package t09_generics_2.exercises.ex03;

import java.util.List;

class Numbers {
    public static double sumNumbers(java.util.List<? extends Number> nums) {
        double sum = 0.0;

        if (nums == null || nums.isEmpty()) {
            return sum;
        }

        for (Number n : nums) {
            sum += n.doubleValue();
        }

        return sum;
    }
}

public class Exercise {
    public static void run() {
        List<Integer> integers = List.of(1, 2, 3);
        List<Double> doubles = List.of(0.5, 1.5, 2.0);
        List<Integer> integers1 = List.of();

        System.out.println(Numbers.sumNumbers(integers));
        System.out.println(Numbers.sumNumbers(doubles));
        System.out.println(Numbers.sumNumbers(integers1));
        System.out.println(Numbers.sumNumbers(null));
    }
}
