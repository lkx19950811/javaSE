package Proxy;

import Proxy.cglibProxy.CglibDynamicProxy;
import Proxy.dynamicProxy.DynamicProxy;
import Proxy.pojo.Math;
import Proxy.pojo.MyMath;
import Proxy.pojo.WasteTime;
import Proxy.staticProxy.StaticMathProxy;
import org.junit.jupiter.api.Test;

/**
 * author : lee Cather <br>
 * date : 2018-10-30 16:39 <br>
 * desc : 代理类测试 <br>
 */
class ProxyTest {
    /**
     * 静态代理测试
     */
    @Test
    void staticProxytest(){
        MyMath math = new StaticMathProxy();
        int n = 50,m = 2;
        math.add(n,m);
        math.div(n,m);
        math.mut(n,m);
        math.sub(n,m);
    }

    /**
     * jdk 动态代理 只能代理 实现了接口的类
     */
    @Test
    void dynamicProxyTest(){
        MyMath math = (MyMath)new DynamicProxy().getProxyObject(new Math());
        int n = 50,m = 2;
        math.add(n,m);
        math.sub(n,m);
        math.mut(n,m);
        math.div(n,m);
    }

    /**
     * cglib动态代理 类无需实现接口
     */
    @Test
    void cglibProxyTest(){
        MyMath math = (MyMath)new CglibDynamicProxy().getProxyObject(new Math());
        int n = 50,m = 2;
        math.add(n,m);
        math.sub(n,m);
        math.mut(n,m);
        math.div(n,m);
    }

    /**
     * 另一个被代理的类,没有实现接口的
     * @throws InterruptedException
     */
    @Test
    void cglibProxyTest2() throws InterruptedException {
        WasteTime time = (WasteTime)new CglibDynamicProxy().getProxyObject(new WasteTime());
        time.testTime();
    }
}
