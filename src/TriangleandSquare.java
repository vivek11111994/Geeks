import java.util.Scanner;

public class TriangleandSquare {
    public void func() {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        while(t-- > 0) {
            int n = in.nextInt();

            if(n%2 == 0) {
                System.out.println(((n-1)*(n-1))/8);
            } else {
                System.out.println(((n-2)*(n-2))/8);
            }
        }
    }
}
