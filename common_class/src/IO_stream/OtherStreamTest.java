package IO_stream;

import org.junit.Test;

import java.io.*;

/**
 * @author JeffCar
 * @date 12/4/2020 - 3:58 PM
 *
 * 标准的输入输出流   System.out/  System.in  字节流
 * 打印流 PrintStream  PrintWriter
 * 数据流 DataInputStream DataOutputStream
 * 对象流
 */
public class OtherStreamTest {
    @Test
    public void test(){
        //序列化过程
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
            oos.writeObject(new String("我爱北京天安门"));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos!=null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void test2(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));
            Object o = ois.readObject();
            String str = (String) o;
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois!=null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
