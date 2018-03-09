package tree;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 21:55 2018/3/8
 * @ ModifiedBy:
 */
public class LongestSubstringWithoutDup {
    public static int longestSubstringWithoutDuplication(String s) {
        int curLength = 0, maxLength = 0;
        int[] prevIndex = new int[26];
        int n = s.length();
        for (int i = 0; i < prevIndex.length; i++) {
            prevIndex[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (i - prevIndex[c - 'a'] > curLength || prevIndex[c - 'a'] < 0)
                curLength++;
            else {
                curLength = i - prevIndex[c - 'a'];
            }
            prevIndex[c-'a'] = i;
            maxLength = Math.max(curLength, maxLength);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abcardf";
        System.out.println(LongestSubstringWithoutDup.longestSubstringWithoutDuplication(s));
    }
}
