package t08_generics_1.exercises.ex07;

import java.util.LinkedList;

final class MessageBus<T> {

    private final LinkedList<T> queue = new LinkedList<>();

    public void enqueue(T msg) {
        queue.addLast(msg);
    }

    public T dequeue() {
        if (queue.isEmpty()) return null;
        return queue.removeFirst();
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}

public class Exercise {
    public static void run() {
        MessageBus<String> messageBus = new MessageBus<>();

        messageBus.enqueue("Next stop: Trinity College. Exit through middle doors.");
        messageBus.enqueue("Next stop: O'Connell Street. Please prepare to disembark.");
        messageBus.enqueue("Final stop: Dublin Airport. All passengers must leave the bus.");
        // messageBus.enqueue(201);

        System.out.println("messageBus.size(): " + messageBus.size());

        System.out.println("messageBus.isEmpty(): " + messageBus.isEmpty());
        System.out.println(messageBus.dequeue());
        System.out.println(messageBus.dequeue());
        System.out.println(messageBus.dequeue());
        System.out.println(messageBus.dequeue());
        System.out.println("messageBus.isEmpty(): " + messageBus.isEmpty());
    }
}
