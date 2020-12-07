import org.junit.Test;

import javax.sound.midi.SoundbankResource;
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author JeffCar
 * @date 12/7/2020 - 9:23 PM
 *
 * 从客户端发送图片，服务器保存到本地,并返回“发送成功”给客户端
 */
public class TcpTest3 {

    @Test
    public void client() throws IOException {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),8899);

        OutputStream os = socket.getOutputStream();

        FileInputStream fis = new FileInputStream(new File("image.png"));

        byte[] bytes = new byte[1024];
        int len;
        while ((len = fis.read(bytes)) != -1){
            os.write(bytes,0,len);
        }
        //一定要shutdown 一下！
        socket.shutdownOutput();

        //接收来自服务器端的信息
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buffer = new byte[20];
        int len1;
        while ((len1 = is.read(buffer))!= -1){
            bos.write(buffer,0,len1);
        }

        System.out.println(bos.toString());

        bos.close();
        is.close();
        fis.close();
        os.close();
        socket.close();
    }

    @Test
    public void server() throws IOException {
        ServerSocket ss = new ServerSocket(8899);
        Socket accept = ss.accept();
        InputStream is = accept.getInputStream();

        FileOutputStream fos = new FileOutputStream(new File("image2.png"));

        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer))!= -1){
            fos.write(buffer,0,len);
        }

        //发送给客户端信息
        OutputStream os = accept.getOutputStream();
        os.write("已收到".getBytes());  //发送数据以字节发送

        fos.close();
        is.close();
        accept.close();
        ss.close();
    }
}
