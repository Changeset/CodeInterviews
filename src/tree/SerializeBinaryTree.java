package tree;

import java.io.OutputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 10:44 2018/3/8
 * @ ModifiedBy:
 */
public class SerializeBinaryTree {
    private static final String SPLITER = ",";
    private static final String NULL = "null";
    public String serialize(TreeNode root)  {
        return serialize(root, new StringBuilder()).toString();
    }

    public StringBuilder serialize(TreeNode root, StringBuilder st) {
        if (root == null) st.append(NULL + SPLITER);
        else {
            st.append(root.val + SPLITER);
            serialize(root.left, st);
            serialize(root.right, st);
        }
        return st;
    }

    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(SPLITER)));
        return deserialize(queue);
    }

    public TreeNode deserialize(Queue<String> queue) {
        String cur = queue.poll();
        if (cur.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(cur));
        root.left = deserialize(queue);
        root.right = deserialize(queue);
        return root;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        SerializeBinaryTree s = new SerializeBinaryTree();
        String res = s.serialize(root);
        System.out.println(res);
        root = s.deserialize(res);
    }
}
