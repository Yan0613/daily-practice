import java.util.Deque;
import java.util.LinkedList;

public class evalNPL {
    public int evalNPL(String[] a) {
        // int sum = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < a.length; i++) {
            if (a[i].equals("+")) {
                stack.push(stack.pop() + stack.pop());
            }
            if (a[i].equals("-")) {
                stack.push(-stack.pop() + stack.pop());
            }
            if (a[i].equals("*")) {
                stack.push(stack.pop() * stack.pop());
            }
            if (a[i].equals("/")) {
                int tmp1 = stack.pop();
                int tmp2 = stack.pop();
                stack.push(tmp2 / tmp1);
                // stack.push(stack.pop() / stack.pop());
                // pay attentiom to '/'
            } else {
                stack.push(Integer.parseInt(a[i]));
            }
        }
        return stack.pop();
    }
}