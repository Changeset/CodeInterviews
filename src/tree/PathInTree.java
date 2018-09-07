package tree;

import com.mysql.cj.x.protobuf.MysqlxCrud;

import java.util.ArrayList;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 20:51 2018/3/7
 * @ ModifiedBy:
 */
public class PathInTree {
    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) return listAll;
        list.add(root.val);
        target -= root.val;
        if (target == 0 && root.left == null && root.right == null) {
            listAll.add(new ArrayList<>(list));
        }
        FindPath(root.left, target);
        FindPath(root.right, target);
        list.remove(list.size() - 1);
        return listAll;
    }
    public static void main(String[] args) {
        PathInTree p = new PathInTree();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        System.out.println(p.FindPath(root, 22));
    }
}
