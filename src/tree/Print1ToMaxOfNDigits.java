package tree;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 16:13 2018/3/6
 * @ ModifiedBy:
 */
public class Print1ToMaxOfNDigits {
    public void print1ToMaxOfNDigits(int n) {
        if (n <= 0) return ;
        char[] number = new char[n+1];
        while (!increment(number)) {
            PrintNumber(number);
        }
    }

    public void print1ToMaxOfNDigits2(int n) {
        if (n <= 0) return;
        char[] number = new char[n];
        for (int i = 0; i < 10; i++) {
            number[0] = (char)(i + '0');
            print1ToMaxOfNDigitsRecursively(number, n, 0);
        }
    }

    public void print1ToMaxOfNDigitsRecursively(char[] number, int length, int index) {
        if (index == length - 1) {
            PrintNumber(number);
            return;
        }

        for (int i = 0; i < 10; i++) {
            number[index + 1] = (char)(i + '0');
            print1ToMaxOfNDigitsRecursively(number, length, index + 1);
        }
    }
    public boolean increment(char[] number) {
        boolean isOverflow = false;
        int nTakeOver = 0;
        int nLength = number.length;
        for (int i = nLength - 1; i >= 0; i--) {
            int nSum = number[i] - '0' + nTakeOver;
            if (i == nLength - 1) nSum++;
            if (nSum >= 10) {
                if (i == 0) isOverflow = true;
                else {
                    nSum -= 10;
                    nTakeOver = 1;
                    number[i] = (char)('0' + nSum);
                }
            }
            else {
                number[i] = (char)('0' + nSum);
                break;
            }
        }
        return isOverflow;
    }

    public void PrintNumber(char[] number) {
        boolean isBeginning0 = true;
        int nLength = number.length;
        for (int i = 0; i < nLength; i++) {
            if (isBeginning0 && number[i] != '0') isBeginning0 = false;
            if (!isBeginning0) System.out.println(number[i]);
        }
        System.out.println();
    }
}
