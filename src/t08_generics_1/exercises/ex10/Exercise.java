package t08_generics_1.exercises.ex10;

import java.util.ArrayList;
import java.util.function.Supplier;

final class ObjectPool<T> {

    Supplier<T> _factory;
    ArrayList<T> _pool = new ArrayList<>();

    public ObjectPool(Supplier<T> factory) {
        if (factory == null) {
            throw new NullPointerException("Supplier is null");
        }
        _factory = factory;
    }

    public T acquire() {
        if (_pool.isEmpty()) return _factory.get();
        return _pool.removeLast();
    }

    public void release(T obj) {
        if (obj == null) {
            throw new NullPointerException("Object is null");
        }
        _pool.add(obj);
    }
}

public class Exercise {
    public static void run() {
        ObjectPool<StringBuilder> pool = new ObjectPool<>(StringBuilder::new);

        StringBuilder a = pool.acquire();
        a.append("hi");
        pool.release(a);

        StringBuilder b = pool.acquire();
        System.out.println(a == b); // true (reused)
    }
}
