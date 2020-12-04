package IO_stream;

import org.junit.Test;

import java.io.*;

/**
 * @author JeffCar
 * @date 12/4/2020 - 2:25 PM
 */
public class BufferedTest {

    @Test
    public void test() throws FileNotFoundException {
        File srcFile = new File("image.png");
        File destFile = new File("image2.png");
        FileInputStream fis = new FileInputStream(srcFile);
        FileOutputStream fos = new FileOutputStream(destFile);
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);


    }
}
