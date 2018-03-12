package tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 20:11 2018/3/12
 * @ ModifiedBy:
 */
public class QueueWithMax59<T extends Comparable<T>> {
    private class InternalData {
        T number;
        int index;
    }
    private Deque<InternalData> data;
    private Deque<InternalData> maximums;
    private int currentIndex;
    public QueueWithMax59() {
        maximums = new LinkedList<>();
        data = new LinkedList<>();
    }
    public void push(T number) {
        while (!maximums.isEmpty() && greater(number, maximums.getLast().number))
            maximums.pollLast();
        InternalData internalData = new InternalData();
        internalData.number = number;
        internalData.index = currentIndex;
        data.add(internalData);
        maximums.add(internalData);
        ++currentIndex;
    }

    public void pop() {
        if (maximums.isEmpty()) throw new NoSuchElementException();
        if (maximums.peek().index == data.peek().index)
            maximums.pop();
        data.pop();
    }

    public T max() {
        if (maximums.isEmpty()) throw new NoSuchElementException();
        return maximums.getFirst().number;
    }

    public boolean greater(T number1, T number2) {
        return number1.compareTo(number2) >= 0;
    }

    public static void main(String[] args) {
        QueueWithMax59 q = new QueueWithMax59();
        int[] num = {2,3,4,2,6,2,5,1};
        for (int i = 0; i < num.length; i++) {
            q.push(num[i]);
            if (i >= 2) {
                System.out.println(q.max());
                q.pop();
            }
        }
    }
}
