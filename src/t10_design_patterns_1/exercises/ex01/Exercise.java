package t10_design_patterns_1.exercises.ex01;

interface AttackStrategy {
    int computeDamage(int baseDamage, int distanceMeters);
}

class MeleeAttack implements AttackStrategy {
    @Override
    public int computeDamage(int baseDamage, int distanceMeters) {
        if (distanceMeters <= 2) return baseDamage + 5;
        return 0;
    }
}

class RangedAttack implements AttackStrategy {
    @Override
    public int computeDamage(int baseDamage, int distanceMeters) {
        if (distanceMeters <= 10) return baseDamage;
        return 0;
    }
}

class Enemy {
    String name;
    int baseDamage;
    AttackStrategy strategy;

    public Enemy(String name, int baseDamage, AttackStrategy strategy) {
        this.name = name;
        this.baseDamage = baseDamage;
        this.strategy = strategy;
    }

    public String getName() {
        return this.name;
    }

    public int attack(int distanceMeters) {
        return strategy.computeDamage(baseDamage, distanceMeters);
    }
}

public class Exercise {
    public static void run() {
        Enemy skeleton = new Enemy("Skeleton", 10, new MeleeAttack());
        Enemy archer = new Enemy("Archer", 10, new RangedAttack());

        int[] distances = new int[] { 1, 5, 12 };

        for (int d : distances) {
            System.out.println(skeleton.getName() + " at " + d + "m: " + skeleton.attack(d));
        }

        for (int d : distances) {
            System.out.println(archer.getName() + " at " + d + "m: " + archer.attack(d));
        }
    }
}
