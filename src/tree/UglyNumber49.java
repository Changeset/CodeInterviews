package tree;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 9:31 2018/3/9
 * @ ModifiedBy:
 */
public class UglyNumber49 {
    public int getUnglyNumber(int index) {
        if (index <= 0) return 0;
        int[] UglyNumbers = new int[index];
        UglyNumbers[0] = 1;
        int nextUglyIndex = 1;

        int[] Multiply2 = UglyNumbers;
        int[] Multiply3 = UglyNumbers;
        int[] Multiply5 = UglyNumbers;

        while (nextUglyIndex < index) {
            int i2=0, i3=0, i5=0;
            int min = minimum(Multiply2[i2] * 2, Multiply3[i3]*3, Multiply5[i5]*5);
            UglyNumbers[nextUglyIndex] = min;
            while (Multiply2[i2] * 2 <= min) ++i2;
            while (Multiply3[i3] * 2 <= min) ++i3;
            while (Multiply5[i5] * 2 <= min) ++i5;
            ++nextUglyIndex;
        }
        int ugly = UglyNumbers[nextUglyIndex-1];
        return ugly;
    }

    private int minimum(int number1, int number2, int number3) {
        int min = (number1 < number2) ? number1 : number2;
        min = (min < number3) ? min : number3;
        return min;
    }
}
