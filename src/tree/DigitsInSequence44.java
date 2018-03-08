package tree;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 21:10 2018/3/8
 * @ ModifiedBy:
 */
public class DigitsInSequence44 {
    public int digitAtIndex(int index) {
        if (index < 0) return -1;
        int digits = 1;
        while (true) {
            int numbers = countOfIntegers(digits);
            if (index < numbers * digits)
                return digitAtIndex(index, digits);
            index -= digits * numbers;
            digits++;
        }
    }

    public int countOfIntegers(int digits) {
        if (digits == 1)
            return 10;
        int count = (int)Math.pow(10, digits - 1);
        return 9 * count;
    }

    int digitAtIndex(int index, int digits) {
        int number = beginNumber(digits) + index / digits;
        int indexFromRight = digits - index % digits;
        for (int i = 1; i < indexFromRight; i++) {
            number /= 10;
        }
        return number % 10;
    }

    private int beginNumber(int digits) {
        if (digits == 1)
            return 0;
        return (int)Math.pow(10, digits - 1);
    }
}
