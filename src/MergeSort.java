import java.util.List;

public class MergeSort {
    public static void merge(int[] arr, int start, int mid, int end) {
        int[] left = new int[mid-start+1];
        int[] right = new int[end-mid];

        int m = 0;
        for (int i = start; i <= mid; i++) {
            left[m] = arr[i];
            m++;
        }

        m = 0;
        for (int i = mid+1; i <= end; i++) {
            right[m] = arr[i];
            m++;
        }

        int k = start, i = 0, j= 0;

        while (i < left.length && j < right.length){
            if(left[i] < right[j]) {
                arr[k] = left[i];
                i++;
                k++;
            } else {
                arr[k] = right[j];
                j++;
                k++;
            }
        }

        while(i < left.length) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while(j < right.length) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    public static void sort(int[] arr, int start, int end) {
        if(start < end) {
            int mid = (start + end) / 2;

            sort(arr, start, mid);
            sort(arr, mid + 1, end);

            merge(arr, start, mid, end);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10,9,8,7,6,5,4,3,2,1};

        sort(arr, 0, arr.length-1);

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
