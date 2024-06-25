package PriorityQueue.MaxHeap;

public class Test {
    public static void main(String[] args) {
        Kitchen mainKitchen = new Kitchen("Main Kitchen", 2);

        Order salad = new Order("Salad", OrderType.THIRD_COURSE);
        Order cheeseCake = new Order("Cheese Cake", OrderType.DESERT);
        Order chickenCurry = new Order("Chicken Curry", OrderType.MAIN_COURSE);
        Order gazpacho = new Order("Gazpacho", OrderType.SECOND_COURSE);
        Order beer = new Order("Cup of Beer", OrderType.DRINK);

        System.out.println("Try to add salad - " + mainKitchen.addOrderToQueue(salad));
        System.out.println("Try to add cheese cake - " + mainKitchen.addOrderToQueue(cheeseCake));
        System.out.println("Try to add chicken curry - " + mainKitchen.addOrderToQueue(chickenCurry));
        System.out.println("Try to add gazpacho - " + mainKitchen.addOrderToQueue(gazpacho));
        System.out.println("----");
        System.out.println("Orders -> " + mainKitchen.getOrders());
        System.out.println("----");
        System.out.println("Execute -> " + mainKitchen.executeOrder());
        System.out.println("Execute -> " + mainKitchen.executeOrder());
        System.out.println("----");
        System.out.println("Try to add salad - " + mainKitchen.addOrderToQueue(salad));
        System.out.println("Try to add gazpacho - " + mainKitchen.addOrderToQueue(gazpacho));
        System.out.println("Try to add beer - " + mainKitchen.addOrderToQueue(beer));
        System.out.println("----");
        System.out.println("Execute -> " + mainKitchen.executeOrder());
        System.out.println("Try to add beer - " + mainKitchen.addOrderToQueue(beer));
        System.out.println("----");
        System.out.println("Orders -> " + mainKitchen.getOrders());
        System.out.println("----");
        while (!mainKitchen.isEmpty()){
            System.out.println("Execute -> " + mainKitchen.executeOrder());
        }
    }
}
