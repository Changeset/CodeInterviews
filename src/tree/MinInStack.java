package tree;

import java.util.Stack;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 11:11 2018/3/7
 * @ ModifiedBy:
 */
public class MinInStack {
    Stack<Long> stack;
    long min;
    public MinInStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(0L);
            min = x;
        }else{
            stack.push(x-min);
            if (x < min) min = x;
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;
        long pop = stack.pop();
        if (pop<0) min = min - pop;
    }

    public int top() {
        long top = stack.peek();
        if (top > 0) {
            return (int)(top+min);
        }else{
            return (int)(min);
        }
    }

    public int getMin() {
        return (int)min;
    }
}
