package tree;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 10:59 2018/3/7
 * @ ModifiedBy:
 */
import java.util.*;
public class PrintMatrix29 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int start = 0;
        ArrayList<Integer> res = new ArrayList<Integer>();
        while (cols > start * 2 && rows > start * 2) {
            ArrayList<Integer> list = printInCircle(matrix, rows, cols, start);
            res.addAll(list);
            ++start;
        }
        return res;
    }

    public ArrayList<Integer> printInCircle(int[][] matrix, int rows, int cols, int start) {
        int endX = cols - 1 - start;
        int endY = rows - 1 - start;
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i = start; i <= endX; i++) {
            int number = matrix[start][i];
            res.add(number);
        }
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                res.add(matrix[i][endX]);
            }
        }
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; i--) {
                res.add(matrix[endY][i]);
            }
        }
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; i--) {
                res.add(matrix[i][start]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        PrintMatrix29 p = new PrintMatrix29();
        int[][] matrix = {{1},{2},{3},{4},{5}};
        ArrayList<Integer> res = p.printMatrix(matrix);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
