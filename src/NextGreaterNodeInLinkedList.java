public class NextGreaterNodeInLinkedList {
        public static void main (String[] args) {
                ListNode head = new ListNode (9);
                head.next = new ListNode (7);
                head.next.next = new ListNode (6);
                head.next.next.next = new ListNode (7);
                head.next.next.next.next = new ListNode (6);
                head.next.next.next.next.next = new ListNode (9);

                int[] res = nextLargerNodes (head);

                for (int i = 0; i < res.length; i++) {
                        System.out.print (res[i] + ", ");
                }

                System.out.println ();
        }

        public static int[] nextLargerNodes (ListNode head) {
                ListNode node = head;
                int length = 0;

                while (node != null) {
                        node = node.next;
                        length++;
                }

                int[] res = new int[length];

                nextLargerNodesUtils (head, 0, res, 0);

                return res;
        }

        private static void nextLargerNodesUtils (ListNode head, int i, int[] res, int max) {
                if (head.next == null) {
                        res[i] = 0;
                        return;
                }

                nextLargerNodesUtils (head.next, i + 1, res, max);

                if (head.next.val > head.val) {
                        res[i] = head.next.val;
                } else if (res[i + 1] > head.val) {
                        res[i] = res[i + 1];
                } else if (max > head.val) {
                        res[i] = max;
                } else {
                        res[i] = 0;
                }

                if (res[i] > max) {
                        max = res[i];
                }
        }
}


//[0,9,7,9,9,0]
// 9 7 6 7 6 9
// 0 0 7 9 9 0
