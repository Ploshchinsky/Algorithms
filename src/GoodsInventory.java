/*
*
* GoodsInventory
*
* Given: different classes of goods inherited from Goods
* Task: to count the number of goods of each class within a collection (e.g. ArrayList).
*
* */

import java.util.*;

public class GoodsInventory {
    public static void main(String[] args) {
        List<Goods> goodsList = new ArrayList<>();
        goodsList.add(new Phone("Iphone 13", 699));
        goodsList.add(new Phone("Iphone 14", 799));
        goodsList.add(new Notebook("Macbook Pro 2023", 1699));
        goodsList.add(new Notebook("Macbook Pro 2024", 1899));
        goodsList.add(new Notebook("Lenovo Legion Pro 5", 1460));
        goodsList.add(new SoundBar("Marshall", 460));
        goodsList.add(new SoundBar("Sony", 390));
        goodsList.add(new Phone("Iphone X", 249));


        System.out.println(goodsCounter(goodsList));
        System.out.println(goodsCounterAlt(goodsList));

    }

    public static Map<String, Integer> goodsCounter(List<Goods> goodsList) {
        Map<String, Integer> goodsMap = new HashMap<>();
        for (Goods element : goodsList) {
            String className = element.getClass().getName();
            goodsMap.put(className, goodsMap.getOrDefault(className, 0) + 1);
        }
        return goodsMap;
    }

    public static String goodsCounterAlt(List<Goods> goodsList) {
        StringBuilder result = new StringBuilder();
        Collections.sort(goodsList);
        String currentGood = goodsList.get(0).getClass().getName();
        int counter = 0;

        for (int i = 0; i < goodsList.size(); i++) {
            if (!goodsList.get(i).getClass().getName().equals(currentGood)) {
                result.append(currentGood + " " + counter + ";");
                currentGood = goodsList.get(i).getClass().getName();
                counter = 0;
            }
            counter++;
            if (i == goodsList.size() - 1){
                result.append(currentGood + " " + counter + ";");
                currentGood = goodsList.get(i).getClass().getName();
            }
        }
        return result.toString();
    }
}

abstract class Goods implements Comparable<Goods> {
    private String name;
    private int price;

    public Goods(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

}

class Phone
        extends Goods {
    public Phone(String name, int price) {
        super(name, price);
    }

    @Override
    public int compareTo(Goods anotherGood) {
        return this.toString().compareTo(anotherGood.toString());
    }
}

class Notebook
        extends Goods {
    public Notebook(String name, int price) {
        super(name, price);
    }

    @Override
    public int compareTo(Goods anotherGood) {
        return this.toString().compareTo(anotherGood.toString());
    }
}

class SoundBar
        extends Goods {
    public SoundBar(String name, int price) {
        super(name, price);
    }

    @Override
    public int compareTo(Goods anotherGood) {
        return this.toString().compareTo(anotherGood.toString());
    }
}
