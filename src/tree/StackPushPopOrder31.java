package tree;

import java.util.Stack;

/**
 * @ Author: Xuelong Liao
 * @ Description:
 * @ Date: created in 11:30 2018/3/7
 * @ ModifiedBy:
 */
public class StackPushPopOrder31 {
    public boolean isPopOrder(int[] push, int[] pop) {
        boolean possible = false;
        Stack<Integer> stack = new Stack<>();
        if (push == null || pop == null) return push == pop;
        int index = 0;
        for (int i = 0; i < pop.length; i++) {
            if (!stack.contains(pop[i]) && index < pop.length) {
                while(index < pop.length) {
                    if (push[index] != pop[i]) {
                        stack.push(push[index]);
                        index++;
                    }
                    else {
                        stack.push(push[index++]);
                        break;
                    }
                }

                if(stack.pop() != pop[i]) return false;
            }
            else if (stack.contains(pop[i])) {
                if (stack.pop() != pop[i]) return false;
            }
        }
        return true;
    }

    public boolean IsPopOrder(int[] push, int[] pop) {
        if (push.length == 0) return false;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0, j = 0; i < push.length;) {
            stack.push(push[i++]);
            while (j < pop.length && stack.peek() == pop[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.empty();
    }
    public static void main(String[] args) {
        StackPushPopOrder31 s = new StackPushPopOrder31();
        int[] push = {1,2,3,4,5};
        int[] pop = {4,5,3,2,1};
        System.out.println(s.isPopOrder(push, pop));
        System.out.println(s.IsPopOrder(push, pop));
    }
}
