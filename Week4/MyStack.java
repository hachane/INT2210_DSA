package Week4;

import java.util.*;

class MyStack {

    Queue<Integer> push;
    Queue<Integer> pop;

    public MyStack() {
        push = new LinkedList<>();
        pop = new LinkedList<>();
    }

    public void push(int x) {
        push.add(x);
    }

    public int top() {
        int size = push.size();

        for (int i = 0; i < size - 1; i++) {
            pop.add(push.poll());
        }

        int ans = push.peek();
        pop.add(push.poll());

        for (int i = 0; i < size; i++) {
            push.add(pop.poll());
        }

        return ans;
    }

    public int pop() {
        int size = push.size();

        for (int i = 0; i < size - 1; i++) {
            pop.add(push.remove());
        }

        int ans = push.remove();

        for (int i = 0; i < size - 1; i++) {
            push.add(pop.remove());
        }

        return ans;
    }

    public boolean empty() {
        return pop.isEmpty() && push.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */