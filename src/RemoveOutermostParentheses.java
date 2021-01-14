import java.util.Stack;

public class RemoveOutermostParentheses {
        public static String removeOuterParentheses (String str) {
                Stack<Integer> stack = new Stack<> ();
                String res = "";

                stack.push (0);
                for (int i = 1; i < str.length (); i++) {
                        if (str.charAt (i) == '(') {
                                stack.push (i);
                        } else if (str.charAt (i) == ')') {
                                int tmp = stack.pop ();

                                if (stack.empty ()) {
                                        res = res + str.substring (tmp + 1, i);
                                }
                        }
                }

                return res;
        }

        public static void main (String[] args) {
                String str = "(()())(())(()(()))";

                System.out.println (removeOuterParentheses (str));
        }
}
