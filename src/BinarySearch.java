public class BinarySearch {
        public static void main (String[] args) {
                Integer[] arr = { 1, 1, 2, 3, 3, 3, 3, 3, 5, 5, 5, 8, 8, 10 };
                Integer key = 3;

                System.out.println ("position in array : " + position (arr, key));

                if (position (arr, key) == - 1) {
                        System.out.println ("ideal Position : " + (leftMostPosition (arr, key) + 1));
                } else {
                        System.out.println ("leftmostPosition : " + leftMostPosition (arr, key));
                        System.out.println ("rightmostPosition : " + rightMostPosition (arr, key));
                }
        }

        private static Integer position (Integer[] arr, Integer n) {
                int left = 0, right = arr.length, mid = 0;

                while (left <= right) {
                        mid = (left + right) / 2;

                        if (arr[mid] > n) {
                                right = mid - 1;
                        }

                        if (arr[mid] < n) {
                                left = mid + 1;
                        }

                        if (arr[mid] == n) {
                                return mid;
                        }
                }

                return - 1;
        }

        private static Integer rightMostPosition (Integer[] arr, int n) {
                int left = 0, right = arr.length, mid = 0;

                while (left < right) {
                        if ((left + right) % 2 == 0)
                                mid = (left + right) / 2;
                        else
                                mid = (left + right) / 2 + 1;

                        if (arr[mid] > n) {
                                right = mid - 1;
                        }

                        if (arr[mid] < n) {
                                left = mid + 1;
                        }

                        if (arr[mid] == n) {
                                left = mid;
                        }
                }

                return left;
        }

        private static Integer leftMostPosition (Integer[] arr, int n) {
                int left = 0, right = arr.length, mid = 0;

                while (left < right) {
                        mid = (left + right) / 2;

                        if (arr[mid] > n) {
                                right = mid - 1;
                        }

                        if (arr[mid] < n) {
                                left = mid + 1;
                        }

                        if (arr[mid] == n) {
                                right = mid;
                        }
                }

                return right;
        }


}
