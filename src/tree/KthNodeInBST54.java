package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class KthNodeInBST54 {
    public static BinaryTreeNode KthNode (BinaryTreeNode root , int k) {
        List<BinaryTreeNode> list = inoderTraversal(root);
        return list.get(k-1);
    }

    public static List<BinaryTreeNode> inoderTraversal(BinaryTreeNode root) {
        BinaryTreeNode node = root;
        if (root == null) return null;
        List<BinaryTreeNode> list = new LinkedList<>();
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root);
            root = root.right;
        }
        return list;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(3);
        root.left = new BinaryTreeNode(1);
        root.right = new BinaryTreeNode(4);
        KthNodeInBST54.KthNode(root, 3);
    }
}
