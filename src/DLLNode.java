import java.util.Stack;

public class DLLNode {
        private int val;
        private DLLNode prev;
        private DLLNode next;
        Stack<Integer> stack = new Stack<> ();

        public DLLNode (int val) {
                this.val = val;
                this.prev = null;
                this.next = null;
        }

        public int getVal () {
                return val;
        }

        public void setVal (int val) {
                this.val = val;
        }

        public DLLNode getPrev () {
                return prev;
        }

        public void setPrev (DLLNode prev) {
                this.prev = prev;
        }

        public DLLNode getNext () {
                return next;
        }

        public void setNext (DLLNode next) {
                this.next = next;
        }

        public static void printDLL (DLLNode head) {
                while (head.next != null) {
                        System.out.print (head.val + " -> ");
                        head = head.next;
                }

                System.out.println (head.val);
        }
}
