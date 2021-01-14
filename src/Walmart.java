public class Walmart {
        public static void main (String[] args) {
                A1 a = new ABC();
                a.test ();
        }
}

interface A1 {
        void test();
}

interface B1 {
        void test();
}

class ABC implements A1, B1 {

        @Override
        public void test () {
                System.out.println ("Something");
        }
}


