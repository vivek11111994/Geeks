import java.util.HashMap;
import java.util.Map;

// Definition for a Node.
class Node {
        int val;
        Node next;
        Node random;

        public Node (int val) {
                this.val = val;
                this.next = null;
                this.random = null;
        }
}

class Solution {
        public Node copyRandomList (Node head) {
                int i = 1;
                Node node = head;
                Map<Node, Integer> correct_position = new HashMap<> ();
                while (node != null) {
                        correct_position.put (node, i++);
                        node = node.next;
                }

                i = 1;
                node = head;
                Map<Integer, Integer> random_position = new HashMap<> ();
                while (node != null) {
                        random_position.put (i++, correct_position.get (node.random));
                        node = node.next;
                }

                Node new_head = new Node (head.val);
                node = head;
                Node new_node = new_head;
                i = 1;
                Map<Integer, Node> position = new HashMap<> ();
                position.put (i++, new_head);

                while (node.next != null) {
                        node = node.next;
                        Node tmp = new Node (node.val);
                        new_node.next = tmp;
                        new_node = tmp;
                        position.put (i++, tmp);
                }

                new_node = new_head;
                i = 1;

                while (new_node != null) {
                        new_node.random = position.get (random_position.get (i++));
                        new_node = new_node.next;
                }

                return new_head;
        }
}

public class CopyLinkedList {
        public static void main (String[] args) {
                Node head = new Node (7);

                Node sec = new Node (13);
                head.next = sec;
                sec.random = head;

                Node third = new Node (11);
                sec.next = third;

                Node fourth = new Node (10);
                third.next = fourth;
                fourth.random = third;

                Node fifth = new Node (1);
                fourth.next = fifth;
                third.random = fifth;
                fifth.random = head;

                System.out.println ("Old LinkedList : \n");
                PrintList (head);

                Solution solution = new Solution ();
                Node newHead = solution.copyRandomList (head);

                System.out.println ("\nNew LinkedList : \n");
                PrintList (newHead);
        }

        public static void PrintList (Node node) {
                while (node != null) {
                        System.out.print (node.val + " --> ");

                        if (node.next != null)
                                System.out.print (node.next.val + " , ");
                        if (node.random != null)
                                System.out.print (node.random.val);

                        System.out.println ();

                        node = node.next;
                }
        }
}