package tree;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 21:28 2018/3/8
 * @ ModifiedBy:
 */
public class MaxValueOfGifts47 {
    public static int getMaxValue_solution1(int[] values, int rows, int cols) {
        if (values == null || rows<= 0 || cols <= 0) return 0;
        int[][] maxValues = new int[rows][];
        for (int i = 0; i < rows; i++) {
            maxValues[i] = new int[cols];
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int left = 0;
                int up = 0;
                if (i > 0) up = maxValues[i-1][j];
                if (j > 0) left = maxValues[i][j-1];
                maxValues[i][j] = Math.max(left, up) + values[i * cols + j];
            }
        }

        int maxValue = maxValues[rows-1][cols-1];
        return maxValue;
    }

    public static void main(String[] args) {
        int[] values = {1, 10, 3, 8,
                        12, 2, 9, 6,
                        5, 7, 4, 11,
                        3, 7, 16, 5};
        System.out.println(MaxValueOfGifts47.getMaxValue_solution1(values, 4, 4));
    }

    private int getMaxValue_solution2(int[] values, int rows, int cols) {
        if (values == null) return 0;
        int[] maxValues = new int[cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int left = 0;
                int up = 0;
                if (i > 0) up = maxValues[j];
                if (j > 0) left = maxValues[j-1];
                maxValues[j] = Math.max(left, up) + values[i * cols + j];
            }
        }
        int maxValue = maxValues[cols-1];
        return maxValue;
    }
}
