package t10_design_patterns_1.real_world_task;


public class Task {

    private final String name;

    Task(String name) {
        this.name = name;
    }

    public void run() {
        System.out.println(name + " run");
    }

    public void validate() {
        System.out.println(name + " validate");
    }
}
