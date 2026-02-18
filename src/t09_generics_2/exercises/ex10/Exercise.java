package t09_generics_2.exercises.ex10;

public class Exercise {
    static void run() {
        String a =  "List<?> a";
        System.out.println(a + " can only add null");                                           // +
        System.out.println(a + " can read Object\n");                                           // +

        String b = "List<? extends Number> b";
        System.out.println(b + " can only add null");                                           // +
        System.out.println(b + " can read Number\n");                                           // +

        String c = "List<? super Integer> c";
        System.out.println(c + " can add Integer, null");                                       // +
        System.out.println(c + " can read Object\n");                                           // +
    }
}
