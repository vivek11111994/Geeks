import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PrintDateTime {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("vivek");
        list.add("awasthi");

        for(String tmp : list) {
            tmp = "vivek1";
        }

        System.out.println(list);
    }
}
