package tree;

import java.util.*;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 16:03 2018/3/5
 * @ ModifiedBy:
 */
public class NextNodeInBinaryTrees {
    private class Node {
        int val;
        Node left;
        Node right;
        Node father;
    }

    public Node nextNode(Node root, Node node) {
        List<Node> list = inorderTraversal(root);
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == node) {
                index = i;
                break;
            }
        }
        if (index + 1 > list.size()) return null;
        else return list.get(index+1);
    }

    public List<Node> inorderTraversal(Node root) {
        Stack<Node> stack = new Stack<>();
        List<Node> list = new ArrayList<>();
        while (root != null || !stack.isEmpty()) {
            stack.push(root);
            while (root.left != null) {
                root = root.left;
                stack.push(root);
            }
            root = stack.pop();
            list.add(root);
            root = root.right;
        }
        return list;
    }
}
