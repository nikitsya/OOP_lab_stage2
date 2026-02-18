package t10_design_patterns_1.exercises.ex03;


class Task {

    String _name;

    public Task(String name) {
        this._name = name;
    }

    void validate() {
        System.out.println("Validating: " + _name);
    }

    void run() {
        System.out.println("Running: " + _name);
    }

    void runUnchecked() {
        System.out.println("Running Unchecked: " + _name);
    }
}

interface Command {
    void execute();
}

interface TaskExecutionStrategy {
    void execute(Task task);
}

class FastExecution implements TaskExecutionStrategy {
    @Override
    public void execute(Task task) {
        task.runUnchecked();
    }
}

class  SafeExecution implements TaskExecutionStrategy {
    @Override
    public void execute(Task task) {
        task.validate();
        task.run();
    }
}

class ExecuteTaskCommand implements Command {

    Task _task;
    TaskExecutionStrategy _strategy;

    public ExecuteTaskCommand(Task task, TaskExecutionStrategy strategy) {
        this._task = task;
        this._strategy = strategy;
    }

    @Override
    public void execute() {
        _strategy.execute(_task);
    }
}

public class Exercise {
    public static void run() {
        Task task = new Task("Export leaderboard");

        Command fast = new ExecuteTaskCommand(task, new FastExecution());
        Command safe = new ExecuteTaskCommand(task, new SafeExecution());

        System.out.println("--- FAST ---");
        fast.execute();

        System.out.println("--- SAFE ---");
        safe.execute();
    }
}
