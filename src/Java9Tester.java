import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author leon
 * @date 2018-05-29 17:37
 * @desc
 */
public class Java9Tester {
    public static void main(String[] args) {
        List.of();
        List list = List.of("Hello", "World");
        System.out.println(list);
        List.of(1, 2, 3);
        Set.of();
        Set.of("Hello", "World");
        Set.of(1, 2, 3);
        Map.of();
        Map.of("Hello", 1, "World", 2);
    }
}
