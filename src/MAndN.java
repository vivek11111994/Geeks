import java.util.Scanner;

public class MAndN {
    private int NumberOfDigits(int n) {
        int count = 0;

        while(n/10 > 0) {
            n = n / 10;
            count++;
        }

        return count++;
    }

    public void func() {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while(t > 0) {
            int m = in.nextInt();
            int n = in.nextInt();

            int sum = m + n;

            if (NumberOfDigits(n) == NumberOfDigits(sum))
                System.out.println(n);
            else
                System.out.println(sum);

            t--;
        }
    }
}
