package BinaryTreeCustom;

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

    public static void add(TreeNode parent, int data) {
        if (data < parent.getData()) {
            if (parent.getLeft() == null) {
                parent.setLeft(new TreeNode(data));
                parent.getLeft().setParent(parent);
                return;
            } else {
                add(parent.getLeft(), data);
            }
        } else {
            if (parent.getRight() == null) {
                parent.setRight(new TreeNode(data));
                parent.getRight().setParent(parent);
            } else {
                add(parent.getRight(), data);
            }
        }
    }

    public static boolean contain(TreeNode parent, int data) {
        if (parent.getData() == data) {
            return true;
        }
        if (data < parent.getData()) {
            if (parent.getLeft() != null) {
                return contain(parent.getLeft(), data);
            }
        } else {
            if (parent.getRight() != null) {
                return contain(parent.getRight(), data);
            }
        }
        return false;
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

