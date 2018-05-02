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
 * @description: ���򷽷�֮lamdba
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
     * �������,����Student����Ҫ�̳�Comparable�ӿ�
     */
    @Test
    public void testSort(){
        Collections.sort(list,Comparator.comparing(o -> o)); //��֪����д��
        Collections.sort(list,Student::compareTo); //ɧ��ʽд�� ��������һ��,���ǵ�����Student�е�compareTo����
        System.out.println(list);
    }
}
