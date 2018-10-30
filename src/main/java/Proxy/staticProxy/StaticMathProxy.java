package Proxy.staticProxy;

import Proxy.pojo.MyMath;
import Proxy.pojo.Math;
import java.util.Random;

/**
 * 静态代理类
 */
public class StaticMathProxy implements MyMath {

 //被代理的对象
 MyMath math=new Math();

 //加
 public int add(int n1, int n2) {
      //开始时间
      long start=System.currentTimeMillis();
      lazy();
      int result=math.add(n1, n2);
      Long span= System.currentTimeMillis()-start;
      System.out.println("共用时："+span);
      return result;
 }

 //减法
 public int sub(int n1, int n2) {
      //开始时间
      long start=System.currentTimeMillis();
      lazy();
      int result=math.sub(n1, n2);
      Long span= System.currentTimeMillis()-start;
      System.out.println("共用时："+span);
      return result;
 }

 //乘
 public int mut(int n1, int n2) {
      //开始时间
      long start=System.currentTimeMillis();
      lazy();
      int result=math.mut(n1, n2);
      Long span= System.currentTimeMillis()-start;
      System.out.println("共用时："+span);
      return result;
 }

 //除
 public int div(int n1, int n2) {
      //开始时间
      long start=System.currentTimeMillis();
      lazy();
      int result=math.div(n1, n2);
      Long span= System.currentTimeMillis()-start;
      System.out.println("共用时："+span);
      return result;
 }

 //模拟延时
 private void lazy()
     {
        try {
           int n = new Random().nextInt(500);
           Thread.sleep(n);
        } catch (InterruptedException e) {
           e.printStackTrace();
        }
     }
}