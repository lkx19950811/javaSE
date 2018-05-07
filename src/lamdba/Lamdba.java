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
 * @description: lamdba表达式测试类
 */
class Lamdba {
    /**
     * 简单实现Runnable,先小试牛刀
     * (params) -> expression
     * (params) -> statement
     * (params) -> { statements }
     */
    @Test
    void threadTest(){
        // Java 8之前：
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Before Java8, too much code for too little to do");
            }
        }).start();
        //Java 8方式：
        new Thread( () -> System.out.println("In Java8, Lambda expression rocks !!") ).start();
    }


    /**
     * 使用Java 8 lambda表达式进行事件处理
     */
    @Test
    void testTask(){
        // Java 8之前：
        JButton show =  new JButton("Show");
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Event handling without lambda expression is boring");
            }
        });
        // Java 8方式：
        show.addActionListener((e) -> System.out.println("Light, Camera, Action !! Lambda expressions Rocks"));
    }

    /**
     * 使用lambda表达式对列表进行迭代
     */
    @Test
    void forEach(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);list.add(2);list.add(3);
        /* 进行迭代循环 */
        list.forEach(n -> System.out.println(n));
        list.forEach(System.out::println);
    }
    /**
     * 使用lambda表达式和函数式接口Predicate
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
        // 不使用lambda表达式为每个订单加上12%的税
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        for (Integer cost : costBeforeTax) {
            double price = cost + .12*cost;
            System.out.println(price);
        }
        // 使用lambda表达式
        List<Integer> costBeforetax = Arrays.asList(100, 200, 300, 400, 500);
        costBeforetax.stream().map((cost) -> cost + .12 * cost).forEach(System.out::println);
    }
    /**
     * MapReduce 2
     */
    @Test
    void mapReduce2(){
        // 为每个订单加上12%的税
        // 老方法：
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        double total = 0;
        for (Integer cost : costBeforeTax) {
            double price = cost + .12*cost;
            total = total + price;
        }
        System.out.println("Total : " + total);

        // 新方法：
        List<Integer> costBeforeTax2 = Arrays.asList(100, 200, 300, 400, 500);
        double bill = costBeforeTax2.stream().map((cost) -> cost + .12*cost).reduce((sum, cost) -> sum + cost).get();
        System.out.println("Total : " + bill);
    }
    /**
     * 通过过滤创建一个String列表
     */
    @Test
    void filtered (){
        List<String> strList = Arrays.asList("abc","dfsad","df","asdf");
        List<String> filtered = strList.stream().filter(x -> x.length()> 2).collect(Collectors.toList());
        System.out.printf("Original List : %s, filtered list : %s %n", strList, filtered);
    }
    /**
     * 对每个元素单独应用函数
     */
    @Test
    void join(){
        // 将字符串换成大写并用逗号链接起来
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
        String G7Countries = G7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(" ,"));
        System.out.println(G7Countries);
    }
    /**
     * 使用distinct过滤重复元素
     */
    @Test
    void distinct(){
        // 用所有不同的数字创建一个正方形列表
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        System.out.printf("Original List : %s,  Square Without duplicates : %s %n", numbers, distinct);
    }
    /**
     * 计算集合元素的最大值、最小值、总和以及平均值
     */
    @Test
    void api(){
        //获取数字的个数、最小值、最大值、总和以及平均值
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
        /**
         *  首先stream()获取数组的source,mapToInt转换,最后获取IntSummaryStatistics对象,
         *  主要用于统计整形数组中元素的最大值，最小值，平均值，个数，元素总和等等
         */
        System.out.println("Highest prime number in List : " + stats.getMax());
        System.out.println("Lowest prime number in List : " + stats.getMin());
        System.out.println("Sum of all prime numbers : " + stats.getSum());
        System.out.println("Average of all prime numbers : " + stats.getAverage());
    }
}
