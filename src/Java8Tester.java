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
}