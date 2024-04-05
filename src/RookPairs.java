import java.util.*;

/*
 *
 * Rook Pairs
 *
 * Given: A field of size N x N (0<=N<=10^9) and an
 * array with rook coordinates (array of size M, 0<=M<=2*10^5).
 *
 * Find: All pairs of rooks that are facing each other (beat each other)
 *
 *
 * Example
 *
 * [ ] [ ] [ ] [ ]
 * [ ] [x] [ ] [ ]
 * [x] [ ] [x] [ ]
 * [ ] [x] [x] [ ]
 *
 * 4 PAIRS
 *
 * */
public class RookPairs {
    private static List<int[]> coordinates;

    public static void main(String[] args) {
        coordinates = coordinatesGenerator();
        System.out.printf("Amount of rook pairs - " + pairCounter(coordinates));
    }

    public static List<int[]> coordinatesGenerator() {
        List<int[]> coordinates = new ArrayList<>();
        coordinates = new ArrayList<>();
        coordinates.add(new int[]{1, 1});
        coordinates.add(new int[]{1, 4});
        coordinates.add(new int[]{1, 8});
        coordinates.add(new int[]{3, 8});
        coordinates.add(new int[]{4, 5});
        coordinates.add(new int[]{6, 1});
        coordinates.add(new int[]{6, 7});
        coordinates.add(new int[]{7, 2});
        coordinates.add(new int[]{9, 2});
        coordinates.add(new int[]{9, 8});
        coordinates.add(new int[]{9, 4});
        return coordinates;
    }

    public static int pairCounter(List<int[]> coordinates) {
        Map<Integer, Integer> horizontalPairs = new HashMap<>();
        Map<Integer, Integer> verticalPairs = new HashMap<>();
        int amount = 0;
        for (int i = 0; i < coordinates.size(); i++) {
            int[] temp = coordinates.get(i);
            int x = temp[0];
            int y = temp[1];
            //Check Horizontal Map
            if (!horizontalPairs.containsKey(x)) {
                horizontalPairs.put(x, 1);
            } else {
                horizontalPairs.put(x, horizontalPairs.get(x) + 1);
            }

            //Check Vertical Map
            if ((!verticalPairs.containsKey(y))) {
                verticalPairs.put(y, 1);
            } else {
                verticalPairs.put(y, verticalPairs.get(y) + 1);
            }
        }
        for (Integer horizontal : horizontalPairs.values()) {
            amount += horizontal - 1;
        }
        for (Integer vertical : verticalPairs.values()) {
            amount += vertical - 1;
        }

        return amount;
    }
}
