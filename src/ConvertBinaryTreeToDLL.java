import com.sun.tools.classfile.ConstantPool;

public class ConvertBinaryTreeToDLL {
        private static DLLNode head = null;
        private static DLLNode curr = null;

        public static void main (String[] args) {
                TreeNode root = new TreeNode (10);
                root.left = new TreeNode (12);
                root.right = new TreeNode (15);
                root.left.left = new TreeNode (25);
                root.left.right = new TreeNode (30);
                root.right.left = new TreeNode (36);

                solve(root);

                DLLNode.printDLL (head);
        }

        private static DLLNode solve (TreeNode root) {
                if(root == null) {
                        return null;
                }

                DLLNode node = new DLLNode (root.val);
                curr = node;

                DLLNode left = solve (root.left);

                if(left != null) {
                        if(head == null) {
                                head = left;
                        }
                        left.setNext (node);
                        node.setPrev (left);
                }

                DLLNode right = solve (root.right);

                if(right != null) {
                        right.setPrev (node);
                        node.setNext (right);

                        curr = right;
                }

                return curr;
        }
}
