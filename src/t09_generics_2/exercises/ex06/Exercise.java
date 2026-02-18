package t09_generics_2.exercises.ex06;

import java.util.ArrayList;
import java.util.List;

class Entity { }

class Enemy  extends Entity { }

class Pickup extends Entity { }

public class Exercise {

    public static void addAllEntities(List<? extends Entity> src, List<? super Entity> dst) {
        if (src == null || dst == null) throw new NullPointerException();
        dst.addAll(src);
    }

    public static void run() {
        ArrayList<Enemy> enemies; enemies = new ArrayList<>(List.of(new Enemy(), new Enemy(), new Enemy()));
        ArrayList<Pickup> pickups; pickups = new ArrayList<>(List.of(new Pickup(), new Pickup()));
        ArrayList<Entity> world =  new ArrayList<>();

        addAllEntities(enemies, world);
        for (Entity e : world) {
            System.out.println(e.getClass().getSimpleName());
        }
        System.out.println(world.size());

        addAllEntities(pickups, world);
        for (Entity e : world) {
            System.out.println(e.getClass().getSimpleName());
        }
        System.out.println(world.size());

        System.out.println(world.getFirst().getClass().getSimpleName());
    }
}
