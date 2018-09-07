package bytedance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 9:59 2018/5/12
 * @ ModifiedBy:
 */

public class Test5 {
    private static void getRes(List<String> list) {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            String line = list.get(i);
            Stack<Character> stack = new Stack<>();

            if (line.contains("//")) count++;
            else if (line.contains("/*")) {
                count++;
                while (i < list.size() && !list.get(i).contains("*/")) i++;
            }
        }
        System.out.println(count);
    }
    public static void main(String[] args) {
        int count = 0;
        Scanner sc = new Scanner(System.in);
        List<String> list =  new ArrayList<>();
        while (sc.hasNext()) {
            String s = sc.nextLine();
            list.add(s);
        }
        getRes(list);
    }
}
