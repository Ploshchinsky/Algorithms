package BinaryTreeCustom;

class BinaryTreeCustomTest {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(10);
        TreeNode node6 = new TreeNode(15);
        TreeNode node7 = new TreeNode(9);

        BinaryTreeCustom binaryTreeCustom = new BinaryTreeCustom();
        binaryTreeCustom.add(node1);
        binaryTreeCustom.add(node2);
        binaryTreeCustom.add(node3);
        binaryTreeCustom.add(node4);
        binaryTreeCustom.add(node5);
        binaryTreeCustom.add(node6);
        binaryTreeCustom.add(node7);
        System.out.println("node7[9] contain in BinaryTree? - " + binaryTreeCustom.contain(node7));
        System.out.println("node3[0] contain in BinaryTree? - " + binaryTreeCustom.contain(node3));
        System.out.println("new Node([9]) contain in BinaryTree? - " + binaryTreeCustom.contain(new TreeNode(9)));
        System.out.println("----");
        System.out.println("new Node([9]) containByData in BinaryTree? - " + binaryTreeCustom.containByData(new TreeNode(9).getData()));
        System.out.println("node3[0] containByData in BinaryTree? - " + binaryTreeCustom.containByData(node3.getData()));
        System.out.println("[11] containByData in BinaryTree? - " + binaryTreeCustom.containByData(11));
        System.out.println("[8] containByData in BinaryTree? - " + binaryTreeCustom.containByData(8));
    }
}
