public class MaxPathSumBinaryTree {
        private static int max = Integer.MIN_VALUE;

        public static void main (String[] args) {
                TreeNode root = new TreeNode (-10);
                root.left = new TreeNode (9);
                root.right = new TreeNode (20);
                root.right.left = new TreeNode (15);
                root.right.right = new TreeNode (7);

                int tmp = maxPathSum (root);

                System.out.println (tmp);
        }

        public static int maxPathSum(TreeNode root) {
                maxPathSumUtil (root);

                return max;
        }

        public static int maxPathSumUtil(TreeNode root) {
                if(root == null) {
                        return 0;
                }

                int left = maxPathSumUtil (root.left);
                int right = maxPathSumUtil (root.right);

                int tmp = Integer.max(Integer.max(left, right)+root.val, root.val);
                int ans = Integer.max(tmp, left+right+root.val);
                max = Integer.max(ans, max);

                return tmp;
        }
}
