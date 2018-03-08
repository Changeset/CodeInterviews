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
        return NumberOf1(strN);
    }

    private int NumberOf1(char[] strN) {
        if (strN == null) return 0;
        int first = strN[0] - '0';
        long length = strN.length;

        if (length == 1 && first == 0) return 0;
        if (length == 1 && first > 0) return 1;

    }

    private 
}
