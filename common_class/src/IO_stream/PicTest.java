package IO_stream;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author JeffCar
 * @date 12/4/2020 - 3:14 PM
 * 图片的加密
 */

public class PicTest {
    @Test
    public void main(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(new File("image.png"));
            fos = new FileOutputStream(new File("image3.png"));

            byte[] buffer = new byte[1024];
            int len;
            while((len = fis.read(buffer))!= -1){
                for (int i = 0; i<len; i++){
                    buffer[i] = (byte) (buffer[i]^5);
                }
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }



    }

}
