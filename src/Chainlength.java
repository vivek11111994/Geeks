// { Driver Code Starts
import java.util.*;
import java.lang.*;

class Pair
{
    int x;
    int y;

    public Pair(int a, int b)
    {
        x = a;
        y = b;
    }
}

class Chainlength
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0)
        {
            int n = sc.nextInt();
            Pair pr[] = new Pair[n];
            int arr[] = new int[2*n];
            for(int i = 0; i < 2*n; i++)
            {
                arr[i] = sc.nextInt();
            }
            for(int i = 0, j = 0; i < 2*n-1 && j < n; i = i+2, j++)
            {
                pr[j] = new Pair(arr[i], arr[i+1]);
            }
            GfG g = new GfG();
            System.out.println(g.maxChainLength(pr, n));
        }
    }
}

class CompareBySecond implements Comparator<Pair>
{
    public int compare(Pair a, Pair b)
    {
        return a.y - b.y;
    }
}

class GfG
{
    int maxChainLength(Pair arr[], int n)
    {
        int globalMax = 1;
        int[] localMax = new int[arr.length];
        CompareBySecond compareBySecond = new CompareBySecond();
        Arrays.sort(arr, compareBySecond);

        localMax[arr.length-1] = 1;

        for(int i = arr.length-2; i >= 0; i--) {
            localMax[i] = 1;
            for(int j = i+1; j < arr.length; j++) {
                if(arr[i].y < arr[j].x) {
                    localMax[i] = localMax[j] + localMax[i];
                    break;
                }
            }

            if(localMax[i] > globalMax)
                globalMax = localMax[i];
        }

        return globalMax;
    }
}