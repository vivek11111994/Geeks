public class Palindrom {
        public static void main (String[] args) {
                String str = "abbcdbba";
                if (checkPalindrom (str, 0, str.length () - 1)) {
                        System.out.println ("Palindrom");
                } else {
                        System.out.println ("Not Palindrom");
                }
        }

        public static boolean checkPalindrom (String str, int start, int end) {
                if (str.charAt (start) != str.charAt (end)) {
                        return false;
                }

                if (start == end || start > end) {
                        return true;
                }

                return checkPalindrom (str, start + 1, end - 1);
        }
}
