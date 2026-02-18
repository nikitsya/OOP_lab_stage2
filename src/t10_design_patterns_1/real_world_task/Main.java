package t10_design_patterns_1.real_world_task;

public class Main {
    public static void main(String[] args) {
        Task task1 = new Task("Task 1");
        Task task2 = new Task("Task 2");
        Task task3 = new Task("Task 3");
        Task task4 = new Task("Task 4");

        TaskExecutionStrategy immediateExecution = new ImmediateExecution();
        TaskExecutionStrategy validatedExecution = new ValidatedExecution();

        ExecuteTaskCommand taskCommand1 = new ExecuteTaskCommand(task1, immediateExecution);
        ExecuteTaskCommand taskCommand2 = new ExecuteTaskCommand(task2, validatedExecution);
        ExecuteTaskCommand taskCommand3 = new ExecuteTaskCommand(task3, validatedExecution);
        ExecuteTaskCommand taskCommand4 = new ExecuteTaskCommand(task4, immediateExecution);

        TaskQueue taskQueue = new TaskQueue();
        taskQueue.submit(taskCommand1);
        taskQueue.submit(taskCommand2);
        taskQueue.submit(taskCommand3);
        taskQueue.submit(taskCommand4);

        taskQueue.processAll();
    }
}
