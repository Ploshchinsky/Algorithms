package PriorityQueue.MinHeap;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Employee {
    private String name;
    private PriorityQueue<Task> tasks;

    public Employee(String name) {
        this.name = name;
        tasks = new PriorityQueue<>(Comparator.comparing(Task::getPriority));
    }

    public boolean addTask(Task task) {
        taskPriorityInit(task);
        return tasks.offer(task);
    }

    private void taskPriorityInit(Task task) {
        switch (task.getType()) {
            case SMALL_SCOPE:
                task.setPriority(0);
                break;
            case MEDIUM_SCOPE:
                task.setPriority(1);
                break;
            case LARGE_SCOPE:
                task.setPriority(2);
                break;
        }
    }

    public Task execute() {
        return tasks.poll();
    }

    public String getTasks() {
        StringBuilder builder = new StringBuilder();
        Iterator<Task> taskIterator = tasks.iterator();
        builder.append("Employee [" + this.name + "] has tasks:\n");
        while (taskIterator.hasNext()) {
            builder.append("\t").append(taskIterator.next());
            if (taskIterator.hasNext()) {
                builder.append("\n");
            }
        }
        return builder.toString();
    }

}
