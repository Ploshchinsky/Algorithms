package PriorityQueue.MaxHeap;

public class Order implements Comparable<Order> {
    private int id;
    private int priority;
    private String name;
    private OrderType type;

    public Order(String name, OrderType type) {
        this.name = name;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OrderType getType() {
        return type;
    }

    public void setType(OrderType type) {
        this.type = type;
    }

    @Override
    public int compareTo(Order anotherOrder) {
        return this.getPriority() - anotherOrder.getPriority();
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", priority=" + priority +
                ", name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
