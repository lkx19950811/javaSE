
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


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
    @Test
    public void testDropWhile() throws Exception {//条件错误时剔除
        final long count = Stream.of(1, 2, 3, 4, 5)
                .dropWhile(i -> i % 2 != 0)
                .count();
        assertEquals(4, count);
    }
    @Test
    public void takeWhile () throws Exception {//当条件对时留下
        final long count = Stream.of(1, 2, 3, 4, 5)
                .takeWhile (i -> i % 2 != 0)
                .count();
        assertEquals(1, count);
    }
    @Test
    public void testFlatMapping() throws Exception { //新的流API
        final Set<Integer> result = Stream.of("卧槽", "abc")
                .collect(Collectors.flatMapping(v -> v.chars().boxed(),
                        Collectors.toSet()));
        assertEquals(5, result.size());
        System.out.println(result);
    }
    private static final System.Logger LOGGER = System.getLogger("Main");
    @Test
    public void Testmain() {//java9 LOG
        LOGGER.log(System.Logger.Level.INFO, "Run!");
    }
}
