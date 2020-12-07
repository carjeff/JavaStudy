import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author JeffCar
 * @date 12/7/2020 - 9:08 PM
 *
 * 从客户端发送图片，服务器保存到本地
 */
public class TcpTest2 {

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


        fos.close();
        is.close();
        accept.close();
        ss.close();
    }
}
