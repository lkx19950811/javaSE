package IO;

import java.io.*;

/**
 * @author leo
 * @date 2018-05-16 16:09
 * @description:
 */
public class ItoO {
    /**
     * 将控制台输入的东西,打印|在a.txt文本文档
     * 输入 "exit"退出
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/a.txt"));
        String line;
        while ((line = bufferedReader.readLine())!=null){
            if (line.equals("exit"))break;
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
