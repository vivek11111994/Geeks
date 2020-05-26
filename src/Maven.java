import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Maven {
    public static void main(String[] args) {
        int[] arr = {2,-2,3,0,4,-7};

        System.out.println(solution(arr));
    }

    private static Integer solution(int[] arr) {
        long sum = 1000000000;
        int count = 1000000000;

        Map<Long, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];

            if(sum == 0) {
                count++;
            }

            if(map.containsKey(sum)) {
                map.get(sum).add(i);
            } else {
                List<Integer> sumList = new ArrayList<>();
                sumList.add(i);

                map.put(sum, sumList);
            }
        }

        for(Map.Entry<Long, List<Integer>> entry : map.entrySet()) {
            Integer duplicate = entry.getValue().size();

            duplicate--;

            count = count + (duplicate*(duplicate+1))/2;
        }

        return count;
    }
}
