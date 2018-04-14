package sohu;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 16:32 2018/4/14
 * @ ModifiedBy:
 */
public class Test1 {
    static class rule1{
        int start;
        int end;
        int sum;
        rule1(int start, int end, int sum) {
            this.start = start;
            this.end = end;
            this.sum = sum;
        }
    }
    static class rule2{
        int taskDate;
        int taskSum;
        rule2(int taskDate, int taskSum) {
            this.taskDate = taskDate;
            this.taskSum = taskSum;
        }
    }
    public static void getRes(List<rule1> r1List, List<rule2> r2List) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int res = 0;
        if (r1List.size() != 0) {
            r1List.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
            List<rule1> result = new LinkedList<>();
            int start = r1List.get(0).start;
            r1List.sort((i1, i2) -> Integer.compare(i2.end, i1.end));
            int end = r1List.get(0).end;
            for (int i = start; i <= end; i++) {
                int sumi = Integer.MIN_VALUE;
                for (rule1 r1 : r1List) {
                    if (r1.start <= i && i <= r1.end) sumi = Math.max(sumi, r1.sum);
                }
                if (sumi > Integer.MIN_VALUE) res += sumi;
            }
        }
        if (r2List.size() != 0) {
            r2List.sort((i1, i2) -> Integer.compare(i1.taskDate, i2.taskDate));
            int start2 = r2List.get(0).taskDate;
            r2List.sort((i1, i2) -> Integer.compare(i2.taskDate, i1.taskDate));
            int end2 = r2List.get(0).taskDate;
            for (int i = start2; i <= end2; i++) {
                int sumi = Integer.MIN_VALUE;
                for (rule2 r2 : r2List) {
                    if (r2.taskDate == i) sumi = Math.max(sumi, r2.taskSum);
                }
                if (sumi > Integer.MIN_VALUE) res += sumi;
            }
        }
        System.out.println(res);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<rule1>  rule1List = new LinkedList<>();
        List<rule2>  rule2List = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int rule = sc.nextInt();
            switch(rule) {
                case 1: {
                    rule1 r1 = new rule1(sc.nextInt(), sc.nextInt(), sc.nextInt());
                    rule1List.add(r1);
                    break;
                }
                case 2: {
                    rule2 r2 = new rule2(sc.nextInt(), sc.nextInt());
                    rule2List.add(r2);
                    break;
                }
            }
        }
        getRes(rule1List, rule2List);
    }
}
