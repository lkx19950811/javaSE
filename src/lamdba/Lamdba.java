package lamdba;

import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author leo
 * @date 2018-04-28 17:38
 * @description: lamdba���ʽ������
 */
public class Lamdba {
    static final Object object = new Object();
    /**
     * ��ʵ��Runnable,��С��ţ��
     * (params) -> expression
     * (params) -> statement
     * (params) -> { statements }
     */
    @Test
    public void threadTest(){
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
    public void testTask(){
        // Java 8֮ǰ��
        JButton show =  new JButton("Show");
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Event handling without lambda expression is boring");
            }
        });
        // Java 8��ʽ��
        show.addActionListener((e) -> {
            System.out.println("Light, Camera, Action !! Lambda expressions Rocks");
        });
    }
}
