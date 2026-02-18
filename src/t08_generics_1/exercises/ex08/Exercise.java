package t08_generics_1.exercises.ex08;

import static java.lang.reflect.Array.newInstance;

public class Exercise {

    @SuppressWarnings("unchecked")
    public static <T> T[] newArray(Class<T> elementType, int length) {

        if (elementType == null) {
            throw new NullPointerException("elementType is null");
        }

        if (length <= 0) {
            throw new IllegalArgumentException("length <= 0");
        }

        return (T[]) newInstance(elementType, length);
    }

    public static void run() {
        String[] names = newArray(String.class, 5);
        System.out.println("names.length: " + names.length);

        Integer[] numbers = newArray(Integer.class, 4);
        numbers[0] = 10;
        numbers[1] = 20;

        System.out.println(numbers[0] + ", " + numbers[1]); // 10, 20
        System.out.println("numbers.length: " + numbers.length);
    }
}
