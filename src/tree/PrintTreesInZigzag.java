package tree;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 15:55 2018/3/7
 * @ ModifiedBy:
 */
public class PrintTreesInZigzag {
    public List<List<Integer>> printInZigzag(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Stack<TreeNode>[] levels = (Stack<TreeNode>[])new Stack[2];
        Stack<TreeNode> stackOdd = new Stack<>();
        Stack<TreeNode> stackEven = new Stack<>();
        stackEven.push(root);
        while (stackOdd.size() > 0 || stackEven.size() > 0) {
            List<Integer> Evenlist = new ArrayList<>();
            while (stackEven.size() > 0) {
                root = stackEven.pop();
                if (root.right != null) stackOdd.push(root.right);
                if (root.left != null) stackOdd.push(root.left);
                Evenlist.add(root.val);
            }
            result.add(Evenlist);
            List<Integer> Oddlist = new ArrayList<>();
            while (stackOdd.size() > 0){
                root = stackOdd.pop();
                if (root.left != null) stackEven.push(root.left);
                if (root.right != null) stackEven.push(root.right);
                Oddlist.add(root.val);
            }
            result.add(Oddlist);
        }
        return result;
    }

    public static void main(String[] args) {
        PrintTreesInZigzag p = new PrintTreesInZigzag();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(5);
        root.right.left = new TreeNode(6);
        p.printInZigzag(root);
    }
}
