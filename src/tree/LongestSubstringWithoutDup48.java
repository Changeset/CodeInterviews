package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 21:55 2018/3/8
 * @ ModifiedBy:
 */
public class LongestSubstringWithoutDup48 {
    public static int longestSubstringWithoutDuplicationMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int longestCur = 0, longestAll = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
                longestCur = map.size();
            }
            else {
                int index = map.get(s.charAt(i));
                if (index + 1 > i) {
                    map.clear();
                    map.put(s.charAt(i), i);
                }
                else {
                    map.clear();
                    for (int j = index + 1; j <= i; j++) {
                        map.put(s.charAt(j), j);
                    }
                }
                longestCur = map.size();
            }
            longestAll = Math.max(longestCur, longestAll);
        }
        return longestAll;
    }

    private static int longestSubstringWithoutDuplication(String s) {
        int curLength = 0, maxLength = 0;
        int[] position = new int[26];
        for (int i = 0; i < 26; i++) {
            position[i] = -1;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int prevIndex = position[c-'a'];
            if (prevIndex < 0 || i - prevIndex > curLength)
                ++curLength;
            else {
                if (curLength > maxLength) maxLength = curLength;
                curLength = i - prevIndex;
            }
            position[c-'a'] = i;
        }
        if (curLength > maxLength) maxLength = curLength;
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "arabcacfrdef";
        System.out.println(LongestSubstringWithoutDup48.longestSubstringWithoutDuplication(s));
    }
}
