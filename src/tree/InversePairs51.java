package tree;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 18:57 2018/3/9
 * @ ModifiedBy:
 */
public class InversePairs51 {
    public int inversePairsCore(int[] data, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = data[start];
            return 0;
        }
        int length = (end - start)/2;
        int left = inversePairsCore(copy, data, start, start + length);
        int right = inversePairsCore(copy, data, start + length + 1, end);

        int i = start + length;
        int j = end;
        int indexCopy = end;
        int count = 0;
        while (i >= start && j >= start + length + 1) {
            if (data[i] > data[j]) {
                copy[indexCopy--] = data[i--];
                count += j-start-length;
            } else {
                copy[indexCopy--] = data[j--];
            }
        }
        for (; i >= start; i--)
            copy[indexCopy--] = data[i];
        for (; j >= start + length + 1; j--)
            copy[indexCopy--] = data[j];
        return left + right + count;
    }
}
