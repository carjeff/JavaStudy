import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author JeffCar
 * @date 12/9/2020 - 5:35 PM
 * <p>
 * 1. URL 统一资源定位符
 * https://localhost:8080/video/BV1Kb411W75N?p=629
 * 协议    主机名    端口号  资源地址         参数列表
 */
public class URLTest {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://localhost:8080/video/BV1Kb411W75N?p=629");
//        System.out.println(url.getProtocol());
//        System.out.println(url.getHost());
//        System.out.println(url.getPort());
//        System.out.println(url.getPath());
//        System.out.println(url.getQuery());
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
    }
}
