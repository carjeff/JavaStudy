package IO_stream;

import org.junit.Test;

import java.io.*;

/**
 * @author JeffCar
 * @date 12/4/2020 - 12:20 PM
 */
public class FileTest {
    @Test
    public void test(){
        File file = new File("hello.txt"); //相对于module的相对路径
        File file1 = new File("D:\\IdeaProject\\stduytemplate\\hello.txt"); //绝对路径


    }
    @Test
    public void test1() throws IOException {
        File file = new File("hello.txt");
        FileReader fileReader = new FileReader(file);
        char[] chars = new char[5];
        int len;
        while ((len = fileReader.read(chars))!=-1){
            for (int i=0; i<len; i++){
                System.out.println(chars[i]);
            }
        }

        fileReader.close();
    }

    @Test
    public void test2(){
        FileReader fr = null;
        FileWriter fw = null;
        try {
            File file = new File("hello.txt");
            File destFile = new File("hello2.txt");

            fr = new FileReader(file);
            fw = new FileWriter(destFile);

            char[] cbuf = new char[5];
            int len;
            while ((len=fr.read(cbuf))!=-1){
                fw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fw!=null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
