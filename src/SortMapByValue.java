import java.util.*;

public class SortMapByValue {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("maths", 90);
        map.put("science", 94);
        map.put("art", 94);
        map.put("history", 89);
        map.put("geography", 90);

        System.out.println(map);

        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue() < o2.getValue())
                    return 1;
                else
                    return -1;
            }
        });

        System.out.println(list);
    }
}
