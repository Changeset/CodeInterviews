package tree;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 21:27 2018/3/12
 * @ ModifiedBy:
 */
public class DicesProbability60 {
    private static final int maxValue = 6;
    public void printProbability(int number) {
        if (number < 1) return;
        int[][] probabilities = new int[2][maxValue * number + 1];
        for (int i = 0; i < maxValue * number + 1; i++) {
            probabilities[0][i] = 0;
            probabilities[0][i] = 0;
        }
        int flag = 0;
        for (int i = 1; i < maxValue; i++) {
            probabilities[flag][i] = 1;
        }
        for (int k = 2; k <= number; k++) {
            for (int i = 0; i < k; i++) {
                probabilities[1-flag][i] = 0;
            }
            for (int i = k; i <= maxValue*k; i++) {
                probabilities[1-flag][i] = 0;
                for (int j = 1; j <= i && j <= maxValue; j++)
                    probabilities[1-flag][i] += probabilities[flag][i-j];
            }
            flag = 1 - flag;
        }

        double total = Math.pow(maxValue, number);
        for (int i = number; i <= maxValue * number; i++) {
            double ratio = (double)probabilities[flag][i]/total;
            System.out.println(i + " " + ratio);
        }
    }

    public static void main(String[] args) {
        DicesProbability60 d = new DicesProbability60();
        d.printProbability(6);
    }
}
