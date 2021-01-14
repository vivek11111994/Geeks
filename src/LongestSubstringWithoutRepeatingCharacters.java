import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class LongestSubstringWithoutRepeatingCharacters {
        public static void main (String[] args) {
                System.out.println (lengthOfLongestSubstring ("abcabcbb"));
        }

        public static int lengthOfLongestSubstring(String s) {
                if(s.length() == 0) {
                        return 0;
                }

                if(s.length() == 1) {
                        return 1;
                }

                Map<Character, Integer> charMap = new HashMap ();
                int ans = 0;
                int left = 0;
                int max = 0;

                for(int i = 0; i < s.length(); i++) {
                        if(charMap.containsKey (s.charAt (i)) && charMap.get (s.charAt (i)) >= left) {
                                if(max < ans) {
                                        max = ans;
                                }

                                left = charMap.get (s.charAt (i))+1;
                                ans = i - left;
                        }

                        charMap.put (s.charAt (i), i);
                        ans++;
                }

                return max > ans ? max : ans;
        }
}