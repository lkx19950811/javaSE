package lamdba;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author leo
 * @date 2018-04-28 17:38
 * @description: lamdba表达式测试类
 */
public class Lamdba {
    static final Object object = new Object();
    /**
     * 简单实现Runnable,先小试牛刀
     * (params) -> expression
     * (params) -> statement
     * (params) -> { statements }
     */
    @Test
    public void threadTest(){
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
    public void testTask(){
        // Java 8之前：
        JButton show =  new JButton("Show");
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Event handling without lambda expression is boring");
            }
        });
        // Java 8方式：
        show.addActionListener((e) -> {
            System.out.println("Light, Camera, Action !! Lambda expressions Rocks");
        });
    }
}
