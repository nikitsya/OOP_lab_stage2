package t09_generics_2.exercises.ex08;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Entity { }
class Enemy extends Entity { }

public class Exercise {

    public static <T> void sortWith(List<T> items, Comparator<? super T> cmp) {
        if (items == null || cmp == null) throw new NullPointerException("Items or Comparator cannot be null");
        items.sort(cmp);
    }

    public static void run() {
        List<Enemy> enemies = new ArrayList<>(List.of(new Enemy(), new Enemy(), new Enemy()));

        for (Enemy e : enemies) System.out.println(e.getClass().getSimpleName()); System.out.println();

        Comparator<Entity> entityComparator = (a, b) -> 0;
        sortWith(enemies, entityComparator);

        for (Enemy e : enemies) System.out.println(e.getClass().getSimpleName());
    }
}