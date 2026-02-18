package t09_generics_2.exercises.ex01;

import java.util.ArrayList;
import java.util.List;

class Entity { }

class Enemy extends Entity { }

class Pickup extends Entity  { }

public class Main {
    public static void main(String[] args) {
        List<Enemy> enemies;
        List<Entity> entities;

        Entity e = new Enemy();

        ArrayList<Enemy> enemies1 = new ArrayList<>();
        ArrayList<Entity>  entities1 = new ArrayList<>();

        // entities = enemies; // should not compile (leave commented out)
    }
}
