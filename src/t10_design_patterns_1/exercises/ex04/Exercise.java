package t10_design_patterns_1.exercises.ex04;

import java.util.ArrayList;
import java.util.List;

interface Command {
    void execute();
}

class PrintCommand implements Command {
    String _message;

    public PrintCommand(String message) {
        this._message = message;
    }

    @Override
    public void execute() {
        System.out.println(_message);
    }
}

class MacroCommand implements Command {

    List<Command> _commands = new ArrayList<>();

    public void add(Command command) {
        _commands.add(command);
    }

    @Override
    public void execute() {
        for (Command command : _commands) {
            command.execute();
        }
    }
}

public class Exercise {
    public static void run() {
        MacroCommand macro = new MacroCommand();
        macro.add(new PrintCommand("start"));
        macro.add(new PrintCommand("validate"));
        macro.add(new PrintCommand("execute"));
        macro.add(new PrintCommand("done"));

        macro.execute();
    }
}
