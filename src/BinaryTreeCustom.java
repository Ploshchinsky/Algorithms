public class BinaryTreeCustom {
    private TreeNode root;

    public BinaryTreeCustom() {
        root = null;
    }

    public void add(TreeNode newNode) {
        TreeNode current = root;
        if (current == null) {
            root = newNode;
            return;
        }
        while (true) {
            if (newNode.getData() < current.getData()) {
                if (current.getLeft() == null) {
                    newNode.setParent(current);
                    current.setLeft(newNode);
                    return;
                }
                current = current.getLeft();
            } else {
                if (current.getRight() == null) {
                    newNode.setParent(current);
                    current.setRight(newNode);
                    return;
                }
                current = current.getRight();
            }
        }
    }

    public boolean contain(TreeNode node) {
        TreeNode current = root;

        while (true) {
            if (current == node) {
                return true;
            }
            if (node.getData() < current.getData()) {
                if (current.getLeft() != null) {
                    current = current.getLeft();
                } else {
                    return false;
                }
            } else {
                if (current.getRight() != null) {
                    current = current.getRight();
                } else {
                    return false;
                }
            }
        }
    }

    public boolean containByData(int data) {
        TreeNode current = root;

        while (true) {
            if (current.getData() == data) {
                return true;
            }
            if (data < current.getData()) {
                if (current.getLeft() != null) {
                    current = current.getLeft();
                } else {
                    return false;
                }
            } else {
                if (current.getRight() != null) {
                    current = current.getRight();
                } else {
                    return false;
                }
            }
        }
    }
}

class TreeNode {
    private int data;
    private TreeNode parent;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}

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
