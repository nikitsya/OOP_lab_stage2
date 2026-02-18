package t08_generics_1.exercises.ex05;

import java.util.ArrayList;
import java.util.Comparator;

final class TopN<T extends Comparable<T>> {

    int _capacity;
    ArrayList<T> _items;

    public TopN(int capacity) {
        if (capacity < 2) throw new IllegalArgumentException("Capacity must be at least 2.");
        _capacity = capacity;
        _items = new ArrayList<>(capacity);
    }

    public void add(T item) {
        if (item == null) throw new NullPointerException("Item cannot be null.");
        _items.add(item);
        _items.sort(Comparator.reverseOrder());
        if (_items.size() <= _capacity) return;
        while (_items.size() > _capacity) {
            _items.removeLast();
        }
    }

    public ArrayList<T> valuesDescending() {
        return _items;
    }
}

public class Exercise {
    public static void run() {
        TopN<Integer> best = new TopN<>(3);
        best.add(2);
        best.add(56);
        best.add(3);
        best.add(39);
        best.add(28);

        System.out.println(best.valuesDescending());

        TopN<String> bestS = new TopN<>(2);
        bestS.add("D");
        bestS.add("B");
        bestS.add("E");
        bestS.add("A");
        bestS.add("C");
        System.out.println(bestS.valuesDescending());
    }
}
