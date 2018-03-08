package tree;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 20:15 2018/3/8
 * @ ModifiedBy:
 */
public class NumberOf143 {
    public int NumberOf1Between1AndN(int n) {
        if (n <= 0) return 0;
        char[] strN;
        String s = "21345";
        strN = s.toCharArray();
        return NumberOf1(strN, 0);
    }

    private int NumberOf1(char[] strN, int index) {
        if (strN == null) return 0;
        int first = strN[index] - '0';
        int length = strN.length-index;

        if (length == 1 && first == 0) return 0;
        if (length == 1 && first > 0) return 1;
        int numFirstDigit = 0;
        if (first > 1)
            numFirstDigit = PowerBase10(length - 1);
        else if (first == 1){
            StringBuilder s = new StringBuilder(strN[index+1]);
            numFirstDigit = Integer.parseInt(s.toString());
        }
        int numOtherDigit = first*(length-1)*PowerBase10(length-2);
        int numRecursive = NumberOf1(strN, index+1);
        return numFirstDigit + numOtherDigit + numRecursive;
    }

    private int PowerBase10(long n) {
        int result = 1;
        for (long i = 0; i < n; i++) {
            result *= 10;
        }
        return result;
    }
}
