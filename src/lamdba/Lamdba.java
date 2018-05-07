package lamdba;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author leo
 * @date 2018-04-28 17:38
 * @description: lamdba���ʽ������
 */
class Lamdba {
    /**
     * ��ʵ��Runnable,��С��ţ��
     * (params) -> expression
     * (params) -> statement
     * (params) -> { statements }
     */
    @Test
    void threadTest(){
        // Java 8֮ǰ��
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Before Java8, too much code for too little to do");
            }
        }).start();
        //Java 8��ʽ��
        new Thread( () -> System.out.println("In Java8, Lambda expression rocks !!") ).start();
    }


    /**
     * ʹ��Java 8 lambda���ʽ�����¼�����
     */
    @Test
    void testTask(){
        // Java 8֮ǰ��
        JButton show =  new JButton("Show");
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Event handling without lambda expression is boring");
            }
        });
        // Java 8��ʽ��
        show.addActionListener((e) -> System.out.println("Light, Camera, Action !! Lambda expressions Rocks"));
    }

    /**
     * ʹ��lambda���ʽ���б���е���
     */
    @Test
    void forEach(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);list.add(2);list.add(3);
        /* ���е���ѭ�� */
        list.forEach(n -> System.out.println(n));
        list.forEach(System.out::println);
    }
    /**
     * ʹ��lambda���ʽ�ͺ���ʽ�ӿ�Predicate
     */
    @Test
    void predicate() {
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

        System.out.println("Languages which starts with J :");
        filter(languages, (str)->str.toString().startsWith("j"));

        System.out.println("Languages which ends with a ");
        filter(languages, (str)->str.toString().endsWith("a"));

        System.out.println("Print all languages :");
        filter(languages, (str)->true);

        System.out.println("Print no language : ");
        filter(languages, (str)->false);

        System.out.println("Print language whose length greater than 4:");
        filter(languages, (str)->str.toString().length() > 4);
    }
    public static void filter(List<String> names, Predicate condition) {
        for(String  name: names)  {
            if(condition.test(name)) {
                System.out.println(name + " ");
            }
        }
    }
    /**
     * MapReduce 1
     */
    @Test
    void mapReduce(){
        // ��ʹ��lambda���ʽΪÿ����������12%��˰
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        for (Integer cost : costBeforeTax) {
            double price = cost + .12*cost;
            System.out.println(price);
        }
        // ʹ��lambda���ʽ
        List<Integer> costBeforetax = Arrays.asList(100, 200, 300, 400, 500);
        costBeforetax.stream().map((cost) -> cost + .12 * cost).forEach(System.out::println);
    }
    /**
     * MapReduce 2
     */
    @Test
    void mapReduce2(){
        // Ϊÿ����������12%��˰
        // �Ϸ�����
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        double total = 0;
        for (Integer cost : costBeforeTax) {
            double price = cost + .12*cost;
            total = total + price;
        }
        System.out.println("Total : " + total);

        // �·�����
        List<Integer> costBeforeTax2 = Arrays.asList(100, 200, 300, 400, 500);
        double bill = costBeforeTax2.stream().map((cost) -> cost + .12*cost).reduce((sum, cost) -> sum + cost).get();
        System.out.println("Total : " + bill);
    }
    /**
     * ͨ�����˴���һ��String�б�
     */
    @Test
    void filtered (){
        List<String> strList = Arrays.asList("abc","dfsad","df","asdf");
        List<String> filtered = strList.stream().filter(x -> x.length()> 2).collect(Collectors.toList());
        System.out.printf("Original List : %s, filtered list : %s %n", strList, filtered);
    }
    /**
     * ��ÿ��Ԫ�ص���Ӧ�ú���
     */
    @Test
    void join(){
        // ���ַ������ɴ�д���ö�����������
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
        String G7Countries = G7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(" ,"));
        System.out.println(G7Countries);
    }
    /**
     * ʹ��distinct�����ظ�Ԫ��
     */
    @Test
    void distinct(){
        // �����в�ͬ�����ִ���һ���������б�
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        System.out.printf("Original List : %s,  Square Without duplicates : %s %n", numbers, distinct);
    }
    /**
     * ���㼯��Ԫ�ص����ֵ����Сֵ���ܺ��Լ�ƽ��ֵ
     */
    @Test
    void api(){
        //��ȡ���ֵĸ�������Сֵ�����ֵ���ܺ��Լ�ƽ��ֵ
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
        /**
         *  ����stream()��ȡ�����source,mapToIntת��,����ȡIntSummaryStatistics����,
         *  ��Ҫ����ͳ������������Ԫ�ص����ֵ����Сֵ��ƽ��ֵ��������Ԫ���ܺ͵ȵ�
         */
        System.out.println("Highest prime number in List : " + stats.getMax());
        System.out.println("Lowest prime number in List : " + stats.getMin());
        System.out.println("Sum of all prime numbers : " + stats.getSum());
        System.out.println("Average of all prime numbers : " + stats.getAverage());
    }
}
