package Graph.DominoWords;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        String[] words = {"Kishinev", "Vyatsk", "Kirov", "Dubrov", "Volgograd", "Ulyanovsk"};
        String[] words2 = {"Adler", "Rybinsk", "Kurgan", "Naryan-Mar", "Rom", "Murmansk", "Konstantinopl"};

        System.out.println("Euler Path 1");
        EulerPath eulerPath = new EulerPath(words);
        System.out.println(eulerPath.getNodes());
        System.out.println(eulerPath.getType());
        String[] path = eulerPath.getEulerPath();
        System.out.println(Arrays.toString(path));
        System.out.println("----");


        System.out.println("Euler Path 2");
        EulerPath eulerPath2 = new EulerPath(words2);
        System.out.println(eulerPath2.getNodes());
        System.out.println(eulerPath2.getType());
        String[] path2 = eulerPath2.getEulerPath();
        System.out.println(Arrays.toString(path2));
        System.out.println("----");
    }
}
