package t09_generics_2.exercises.ex07;

import java.util.ArrayList;
import java.util.List;

class Entity { }
class Enemy extends Entity { }

public class Exercise {

    public static void addEnemies(List<? super Enemy> out) {
        if (out == null) throw new NullPointerException();
        out.addAll(List.of(new Enemy(), new Enemy()));
    }

    public static void run() {
        List<Enemy> enemies = new ArrayList<>();
        List<Entity> entities = new ArrayList<>();
        List<Object> objects = new ArrayList<>();

        addEnemies(enemies);
        addEnemies(entities);
        addEnemies(objects);

        System.out.println(enemies.size());
        System.out.println(entities.size());
        System.out.println(objects.size());

        for (Enemy e : enemies) System.out.println(e.getClass().getSimpleName()); System.out.println();
        for (Entity e : entities) System.out.println(e.getClass().getSimpleName()); System.out.println();
        for (Object o : objects) System.out.println(o.getClass().getSimpleName()); System.out.println();
    }
}
