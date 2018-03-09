package tree;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 10:24 2018/3/9
 * @ ModifiedBy:
 */
public class FirstCharacterInStream50 {
    private int occurence[];
    private int index;
    public FirstCharacterInStream50() {
        index = 0;
        for (int i = 0; i < 256; i++) {
            occurence[i] = -1;
        }
    }
    public void insert(char ch) {
        if (occurence[ch] == -1)
            occurence[ch] = index;
        else if (occurence[ch] >= 0)
            occurence[ch] = -1;
        index++;
    }

    public char firstAppearingOnce() {
        char ch = '\0';
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < 256; i++) {
            if (occurence[i] >= 0 && occurence[i] < minIndex) {
                ch = (char)i;
                minIndex = occurence[i];
            }
        }
        return ch;
    }
}
