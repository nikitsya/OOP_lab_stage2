package t10_design_patterns_1.exercises.ex05;


import java.util.ArrayDeque;

class Counter {

    private int _value = 0;

    void add(int amount) {
        this._value += amount;
    }

    int getValue() {
        return this._value;
    }
}

interface UndoableCommand {
    void execute();
    void undo();
}

class AddNumberCommand implements UndoableCommand {

    private final Counter _counter;
    private final int _amount;

    public AddNumberCommand(Counter counter, int amount) {
        this._counter = counter;
        this._amount = amount;
    }

    @Override
    public void execute() {
        this._counter.add(this._amount);
    }

    @Override
    public void undo() {
        this._counter.add(-this._amount);
    }
}

public class Exercise {
    public static void run() {
        Counter counter = new Counter();
        ArrayDeque<UndoableCommand> history = new ArrayDeque<>();

        executeAndRecord(history, new AddNumberCommand(counter, 5));
        System.out.println("After +5: " + counter.getValue());

        executeAndRecord(history, new AddNumberCommand(counter, 2));
        System.out.println("After +2: " + counter.getValue());

        executeAndRecord(history, new AddNumberCommand(counter, 10));
        System.out.println("After +10: " + counter.getValue());

        undoLast(history);
        System.out.println("After undo: " + counter.getValue());

        undoLast(history);
        System.out.println("After undo: " + counter.getValue());
    }

    private static void executeAndRecord(ArrayDeque<UndoableCommand> history, UndoableCommand command) {
        command.execute();
        history.push(command);
    }

    private static void undoLast(ArrayDeque<UndoableCommand> history) {
        if (history.isEmpty())
            return;

        history.pop().undo();
    }
}
