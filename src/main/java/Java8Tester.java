/**
 * @author leo
 * @date 2018-05-15 11:11
 * @description:
 */
import jdk.nashorn.api.scripting.JSObject;
import org.junit.jupiter.api.Test;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Optional;

public class Java8Tester {
    public static void main(String args[]){

        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");
        String name = "Runoob";
        Integer result = null;
        try {
            nashorn.eval("print('" + name + "')");
            result = (Integer) nashorn.eval("10 + 2");
            nashorn.eval("var a = {\"a\":\"123\"};");
            JSObject jsObject = (JSObject) nashorn.get("a");
            System.out.println(jsObject.getMember("a"));
        }catch(ScriptException e){
            System.out.println("执行脚本错误: "+ e.getMessage());
        }
        System.out.println(result.toString());
    }
    @Test
    public void testClone(){
        String[] strs = {"1","2","3"};
        String[] strs2 = strs.clone();
        strs[1] = "4";
        Arrays.stream(strs).forEach((a)-> System.out.println("strs: " + a));
        Arrays.stream(strs2).forEach((a)-> System.out.println("strs2: " + a));
        System.out.println("..------------------------------------");
        strs2 = strs;
        strs[1] = "sdf";
        Arrays.stream(strs).forEach((a)-> System.out.println("strs: " + a));
        Arrays.stream(strs2).forEach((a)-> System.out.println("strs2: " + a));
    }
    @Test
    public void byteToString() throws UnsupportedEncodingException {
        String abc = "abc";
        Base64.Encoder encoder =  Base64.getEncoder();
        byte[] bytes = encoder.encode(abc.getBytes());
        String result = new String(bytes);
        Base64.Decoder decoder = Base64.getDecoder();
        System.out.println(new String(decoder.decode(result.getBytes())));
    }
    @Test
    public void optionalTest(){
        Integer v1 = null;
        Integer v2 = 10;

        // Optional.ofNullable - 允许传递为 null 参数
        Optional<Integer> a = Optional.ofNullable(v1);

        // Optional.of - 如果传递的参数是 null，抛出异常 NullPointerException
        Optional<Integer> b = Optional.of(v2);
        System.out.println(sum(a,b));
    }
    public Integer sum(Optional<Integer> a, Optional<Integer> b){

        // Optional.isPresent - 判断值是否存在

        System.out.println("第一个参数值存在: " + a.isPresent());
        System.out.println("第二个参数值存在: " + b.isPresent());

        // Optional.orElse - 如果值存在，返回它，否则返回默认值
        Integer value1 = a.orElse(new Integer(0));

        //Optional.get - 获取值，值需要存在
        Integer value2 = b.get();
        return value1 + value2;
    }
}