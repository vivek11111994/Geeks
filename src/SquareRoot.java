//Open https://www.codechef.com/ide to run it

import java.util.*;
import java.lang.*;
import java.io.*;

public class SquareRoot {


        public static void main(String[] str) {
                assertEqual(squareRoot(4L), 2L);
                assertEqual(squareRoot(9), 3L);
                assertEqual(squareRoot(17L), 4L);
                assertEqual(squareRoot(100L), 10L);
                assertEqual(squareRoot(1000L), 31L);
                assertEqual(squareRoot(128781232L), 11348L);
                assertEqual(squareRoot(9999999L), 3162L);
                assertEqual(squareRoot(1522756L), 1234L);
                assertEqual(squareRoot(17L), 4L);
        }

        public static void assertEqual(Object o1, Object o2) {
                if (o1.equals(o2))
                        System.out.println("Pass");
                else
                        System.out.println("Fail");
        }

        // 1          10
        // 1     5    10
        // 1. 2  4
        //    2.3 4
        //.       4 4

        //Please complete the below
        private static long squareRoot(long num) {
                long low = 1;
                long high = num;
                long mid = (low+high)/2;

                while(low < high) {
                        mid = (low+high)/2;

                        if(mid*mid > num) {
                                high = mid;
                        } else if(mid*mid < num) {
                                low = mid;
                        }

                        if(mid*mid == num || (mid*mid < num && (mid+1)*(mid+1) > num)) {
                                return mid;
                        }
                }

                System.out.println (mid);
                return mid;
        }

}