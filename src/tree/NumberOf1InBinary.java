package tree;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 10:06 2018/3/6
 * @ ModifiedBy:
 */
public class NumberOf1InBinary {
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n-1) & n;
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOf1InBinary n = new NumberOf1InBinary();
        System.out.println(n.NumberOf1(-1));
    }
}
