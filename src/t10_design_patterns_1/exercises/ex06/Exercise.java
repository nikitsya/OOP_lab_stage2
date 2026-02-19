package t10_design_patterns_1.exercises.ex06;

import java.util.ArrayDeque;
import java.util.Queue;

class OrderTicket {
    int ticketId;
    String description;
    double totalEuro;
    int itemCount;

    public OrderTicket(int ticketId, String description, double totalEuro, int itemCount) {
        this.ticketId = ticketId;
        this.description = description;
        this.totalEuro = totalEuro;
        this.itemCount = itemCount;
    }

    boolean isValid() {
        return description != null && !description.isEmpty() && !(totalEuro <= 0) && itemCount > 0;
    }


}

interface OrderProcessingStrategy {
    void process(OrderTicket ticket);
}

class ImmediateProcess implements OrderProcessingStrategy {
    @Override
    public void process(OrderTicket ticket) {
        System.out.println("MAKE " + ticket.ticketId + " " + ticket.description + " (€" + ticket.totalEuro + ")");
    }
}

class ValidatedProcess implements OrderProcessingStrategy {
    @Override
    public void process(OrderTicket ticket) {
        if (!ticket.isValid()) {
            System.out.println("REJECT " + ticket.ticketId + " invalid ");
        } else {
            System.out.println("MAKE ...");
        }
    }
}

class DryRunTraining implements OrderProcessingStrategy {
    @Override
    public void process(OrderTicket ticket) {
        System.out.println("TRAINING " + ticket.ticketId + " would make: " + ticket.description + " (€" + ticket.totalEuro + ")");
    }
}

interface Command {
    void execute();
}

class ProcessingPolicySelector {
    public OrderProcessingStrategy select(OrderTicket ticket) {
        if (ticket.description.toLowerCase().contains("training")) {
            return new DryRunTraining();
        } else if (ticket.totalEuro >= 30 || ticket.itemCount >= 6) {
            return new ValidatedProcess();
        }
        return new ImmediateProcess();
    }
}

class TicketQueue {

    Queue<Command> queue = new ArrayDeque<>();

    public void add(Command command) {
        queue.add(command);
    }

    public void processAll() {
        while (!queue.isEmpty()) {
            queue.poll().execute();
        }
    }
}

class ProcessTicketCommand implements Command {
    OrderTicket ticket;
    OrderProcessingStrategy strategy;

    public ProcessTicketCommand(OrderTicket ticket, OrderProcessingStrategy strategy) {
        this.ticket = ticket;
        this.strategy = strategy;
    }

    @Override
    public void execute() {
        strategy.process(ticket);
    }
}

public class Exercise {
    public static void run() {
        ProcessingPolicySelector selector = new ProcessingPolicySelector();
        TicketQueue queue = new TicketQueue();

        OrderTicket t1 = new OrderTicket(201, "1 cappuccino, 1 croissant", 7.80, 2);
        OrderTicket t2 = new OrderTicket(202, "   ", 5.00, 1);
        OrderTicket t3 = new OrderTicket(203, "training: 2 lattes, 1 muffin", 12.50, 3);
        OrderTicket t4 = new OrderTicket(204, "8 americanos, 2 toasties", 42.00, 10);

        enqueue(queue, selector, t1);
        enqueue(queue, selector, t2);
        enqueue(queue, selector, t3);
        enqueue(queue, selector, t4);

        queue.processAll();
    }

    private static void enqueue(TicketQueue queue, ProcessingPolicySelector selector, OrderTicket ticket) {
        OrderProcessingStrategy strategy = selector.select(ticket);
        queue.add(new ProcessTicketCommand(ticket, strategy));
    }
}
