public class LongestPalindromicSubstring {
        public static void main (String[] args) {
                String s = "aba";
                System.out.println (longestPalindrome (s));
        }

        public static String longestPalindrome (String s) {
                String ans = "";

                for (int i = 0; i < s.length (); i++) {
                        for (int j = s.length () - 1; j >= i; j--) {
                                if (s.charAt (i) == s.charAt (j)) {
                                        int start = i;
                                        int end = j;

                                        while (start < end) {
                                                if (s.charAt (start) != s.charAt (end)) {
                                                        break;
                                                }

                                                start++;
                                                end--;
                                        }

                                        if (start >= end && j - i >= ans.length ()) {
                                                ans = s.substring (i, j + 1);
                                        }
                                }
                        }
                }

                return ans;
        }
}
