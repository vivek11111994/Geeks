public class RemoveDuplicatesfromSortedArray {
        public static int removeDuplicates (int[] nums) {
                if (nums.length == 0)
                        return 0;

                if (nums.length == 1)
                        return 1;

                int res = 0;
                int j = 0;

                for (int i = 0; i < nums.length - 1; i++) {
                        if (nums[i] != nums[i + 1]) {
                                res++;
                                nums[j++] = nums[i];
                        }
                }

                if (nums[nums.length - 2] != nums[nums.length - 1]) {
                        res++;
                        nums[j++] = nums[nums.length - 1];
                } else {
                        res++;
                        nums[j++] = nums[nums.length - 2];
                }

                return res;
        }

        public static void main (String[] args) {
                int[] arr = { 1, 1 };

                System.out.println (removeDuplicates (arr));
        }
}
