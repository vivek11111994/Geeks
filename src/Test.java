public class Test {
        int a;
        int b;

        public int add () {
                return this.a + this.b;
        }

        public int result () {
                return new Test ().add ();
        }
}

class Test1 {
        public static void main (String[] args) {
                Test test = new Test ();

                System.out.println (test.add () + test.result ());
        }
}
