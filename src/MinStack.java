import com.sun.org.apache.xml.internal.security.algorithms.implementations.IntegrityHmac;

import java.util.Stack;

public class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        /** initialize your data structure here. */
        public MinStack() {
                stack = new Stack<>();
                minStack = new Stack<> ();
        }

        public void push(int x) {
                stack.push (x);

                if(minStack.empty () || x <= minStack.peek ()) {
                        minStack.push (x);
                }
        }

        public void pop() {
                Integer tmp = stack.pop ();

                if(!minStack.empty () && tmp.equals (minStack.peek ())) {
                        minStack.pop ();
                }
        }

        public int top() {
                return stack.peek ();
        }

        public int getMin() {
                return minStack.peek ();
        }
}

class Driver {
        public static void main (String[] args) {
                MinStack minStack = new MinStack ();

                minStack.push (512);
                minStack.push (-1024);
                minStack.push (-1024);
                minStack.push (512);

                minStack.pop ();
                System.out.println (minStack.getMin ());
                minStack.pop ();
                System.out.println (minStack.getMin ());
                minStack.pop ();
                System.out.println (minStack.getMin ());
        }
}