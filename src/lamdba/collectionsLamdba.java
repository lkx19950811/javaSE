package lamdba;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author leo
 * @date 2018-05-02 14:33
 * @description: 排序方法之lamdba
 */
public class collectionsLamdba {
    static List<Student> list = new ArrayList<Student>();
    @BeforeAll
    public static void init(){
        for (int i = 0;i<15;i++){
            list.add(new Student());
        }
    }

    /**
     * 排序测试,首先Student类需要继承Comparable接口
     */
    @Test
    public void testSort(){
        Collections.sort(list,Comparator.comparing(o -> o)); //不知所云写法
        Collections.sort(list,Student::compareTo); //骚逼式写法 两个本质一样,都是调用了Student中的compareTo方法
        System.out.println(list);
    }
}
