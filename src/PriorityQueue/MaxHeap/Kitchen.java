package PriorityQueue.MaxHeap;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Kitchen {
    private PriorityQueue<Order> orders;
    private String name;
    private int capacity;

    public Kitchen(String name, int ordersQueueCapacity) {
        this.name = name;
        this.orders = new PriorityQueue<>(ordersQueueCapacity, Collections.reverseOrder());
        this.capacity = ordersQueueCapacity;
    }

    public boolean addOrderToQueue(Order order) {
        if (orders.size() <= capacity) {
            orderPriorityInit(order);
            return orders.add(order);
        }
        return false;
    }

    private boolean orderPriorityInit(Order order) {
        switch (order.getType()) {
            case MAIN_COURSE:
                order.setPriority(5);
                order.setId(orders.size());
                return true;
            case SECOND_COURSE:
                order.setPriority(4);
                order.setId(orders.size());
                return true;
            case THIRD_COURSE:
                order.setPriority(3);
                order.setId(orders.size());
                return true;
            case DRINK:
                order.setPriority(2);
                order.setId(orders.size());
                return true;
            case DESERT:
                order.setPriority(1);
                order.setId(orders.size());
                return true;
        }
        return false;
    }

    public Order executeOrder() {
        return orders.poll();
    }

    public String getOrders() {
        StringBuilder builder = new StringBuilder();
        Iterator<Order> orderIterator = orders.iterator();
        builder.append("Kitchen [" + name + "]" + " has orders:\n");
        while (orderIterator.hasNext()) {
            builder.append(orderIterator.next());
            if (orderIterator.hasNext()) {
                builder.append("\n");
            }
        }
        return builder.toString();
    }

    public boolean isEmpty() {
        return orders.isEmpty();
    }
}
