package t08_generics_1.exercises.ex06;

import java.util.HashMap;

final class Registry<K, V> {

    HashMap<K, V> map = new HashMap<>();

    public void put(K key, V value) {
        if (key == null) {
            throw new NullPointerException("key is null");
        }
        map.put(key, value);
    }

    public V get(K key) {
        if (key == null) {
            throw new NullPointerException("key is null");
        }
        if(containsKey(key)) {
            return map.get(key);
        }
        return null;
    }

    public boolean containsKey(K key) {
        if (key == null) {
            throw new NullPointerException("key is null");
        }
        return map.containsKey(key);
    }
}

public class Exercise {
    public static void run() {
        Registry<String, Integer>  registry = new Registry<>();
        registry.put("Liam", 78);
        registry.put("Sophie", 92);
        registry.put("Daniel", 65);
        registry.put("Emma", 88);
        registry.put("Chloe", 96);
        registry.put("Ethan", 81);
        registry.put("Mia", 69);

        System.out.println("registry.containsKey(\"Nikita\") : " + registry.containsKey("Nikita"));
        System.out.println("registry.containsKey(\"Chloe\") : " + registry.containsKey("Chloe"));

        System.out.println("registry.get(\"Nikita\") : " + registry.get("Nikita"));
    }
}
