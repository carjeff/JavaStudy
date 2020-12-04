package IO_stream;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author JeffCar
 * @date 12/4/2020 - 2:07 PM
 */
public class FileInputTest {

    @Test
    public void test(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File srcFile = new File("image.png");
            File destFile = new File("image2.png");
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            byte[] bytes = new byte[5];
            int len;
            while ((len=fis.read(bytes))!=-1){
                fos.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null){

                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null){

                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }


    }
}
