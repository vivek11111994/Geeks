import java.util.HashMap;
import java.util.Map;

public class MinimumNumberofStepstoMakeTwoStringsAnagram {
        public static void main (String[] args) {
                String s = "leetcode", t = "practice";

                System.out.println (minSteps (s, t));
        }

        public static int minSteps (String s, String t) {
                Map<Character, Integer> feqS = new HashMap<> ();
                Map<Character, Integer> feqT = new HashMap<> ();
                Integer steps = 0;

                for (int i = 0; i < s.length (); i++) {
                        if (feqS.containsKey (s.charAt (i))) {
                                feqS.put (s.charAt (i), feqS.get (s.charAt (i)) + 1);
                        } else {
                                feqS.put (s.charAt (i), 1);
                        }

                        if (feqT.containsKey (t.charAt (i))) {
                                feqT.put (t.charAt (i), feqT.get (t.charAt (i)) + 1);
                        } else {
                                feqT.put (t.charAt (i), 1);
                        }
                }

                for (Map.Entry<Character, Integer> entry : feqS.entrySet ()) {
                        if (feqT.containsKey (entry.getKey ())) {
                                if (entry.getValue () > feqT.get (entry.getKey ())) {
                                        steps = steps + entry.getValue () - feqT.get (entry.getKey ());
                                }
                        } else {
                                steps = steps + entry.getValue ();
                        }
                }

                return steps;
        }
}
