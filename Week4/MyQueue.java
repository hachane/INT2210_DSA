package Week4;

import java.util.*;

class MyQueue {
    Stack<Integer> enqueue;
    Stack<Integer> dequeue;

    public MyQueue() {
        enqueue = new Stack<>();
        dequeue = new Stack<>();
    }

    public void push(int x) {
        enqueue.push(x);
    }

    public int pop() {
        if (dequeue.isEmpty()) {
            while (!enqueue.isEmpty()) {
                dequeue.push(enqueue.pop());
            }
        }

        return dequeue.pop();

    }

    public int peek() {
        if (dequeue.isEmpty()) {
            while (!enqueue.isEmpty()) {
                dequeue.push(enqueue.pop());
            }
        }

        return dequeue.peek();

    }

    public boolean empty() {
        return dequeue.isEmpty() && enqueue.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
