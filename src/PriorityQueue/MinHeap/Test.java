package PriorityQueue.MinHeap;

public class Test {
    public static void main(String[] args) {
        Employee emp1 = new Employee("Ivan");
        Employee emp2 = new Employee("Maria");

        Task largeTask1 = new Task("Write a book", ScopeType.LARGE_SCOPE);
        Task largeTask2 = new Task("Build a bicycle", ScopeType.LARGE_SCOPE);
        Task mediumTask1 = new Task("Check the cash register", ScopeType.MEDIUM_SCOPE);
        Task mediumTask2 = new Task("Dust the shelves", ScopeType.MEDIUM_SCOPE);
        Task smallTask1 = new Task("Call the office", ScopeType.SMALL_SCOPE);
        Task smallTask2 = new Task("Lights out", ScopeType.SMALL_SCOPE);

        System.out.println("First Employee added tasks: ");
        System.out.println(emp1.addTask(mediumTask1));
        System.out.println(emp1.addTask(largeTask1));
        System.out.println(emp1.addTask(smallTask1));
        System.out.println("---");
        System.out.println(emp1.getTasks());
        System.out.println("---");
        System.out.println("Second Employee added tasks: ");
        System.out.println(emp2.addTask(mediumTask2));
        System.out.println(emp2.addTask(largeTask2));
        System.out.println(emp2.addTask(smallTask2));
        System.out.println("---");
        System.out.println(emp2.getTasks());
        System.out.println("---");
        System.out.println("Execute tasks Employee 1: ");
        System.out.println(emp1.execute() + " - complete!");
        System.out.println(emp1.execute() + " - complete!");
        System.out.println(emp1.execute() + " - complete!");
        System.out.println("Execute tasks Employee 1: ");
        System.out.println(emp2.execute() + " - complete!");
        System.out.println(emp2.execute() + " - complete!");
        System.out.println(emp2.execute() + " - complete!");
    }
}
