package BinaryTreeCustom;

import java.util.Random;

public class BinaryTreeCustomTest2 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(25);
        treeGeneratorFromRootNode(root);
        System.out.println("Contain [15] - " + BinaryTreeCustom.contain(root, 15));
        System.out.println("Contain [0] - " + BinaryTreeCustom.contain(root, 0));
        System.out.println("Contain [35] - " + BinaryTreeCustom.contain(root, 35));
        System.out.println("Contain [14] - " + BinaryTreeCustom.contain(root, 14));
        System.out.println("Contain [12] - " + BinaryTreeCustom.contain(root, 12));
        System.out.println("Contain [3] - " + BinaryTreeCustom.contain(root, 3));
    }

    private static void treeGeneratorFromRootNode(TreeNode rootNode) {
        System.out.print("[");
        for (int i = 0; i < 10; i++) {
            int randomInt = new Random().nextInt(50) + i;
            BinaryTreeCustom.add(rootNode, randomInt);
            System.out.print(randomInt);
            if (i < 9) {
                System.out.print(" - ");
            }
        }
        System.out.print("]\n");
    }
}
