public class FruitIntoBaskets {
        public static void main (String[] args) {
                int[] arr = {3,3,3,1,2,1,1,2,3,3,4};

                System.out.println (totalFruit (arr));
        }

        public static int totalFruit(int[] tree) {
                int max = Integer.MIN_VALUE, first = -1, second = -1, count = 0;

                for(int i = 0; i< tree.length; i++) {
                        if(first == -1) {
                                first = i;
                                count++;
                        } else if(tree[i] != tree[first] && second == -1) {
                                second = i;
                                count++;
                        } else {
                                if(tree[i] == tree[first] || tree[i] == tree[second]) {
                                        if(second != -1 && tree[i] == tree[first]) {
                                                first = second;
                                                second = i;
                                        }
                                        count++;
                                } else {
                                        count = i-second+1;
                                        first = second;
                                        second = i;
                                }
                        }

                        if(count > max) {
                                max = count;
                        }
                }

                return max;
        }
}
