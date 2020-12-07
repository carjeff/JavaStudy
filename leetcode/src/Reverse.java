import org.junit.Test;

import javax.sound.midi.SoundbankResource;
import java.util.Arrays;

/**
 * @author JeffCar
 * @date 12/7/2020 - 9:41 AM
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例1:
 *
 * 输入: 123
 * 输出: 321
 * 示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为[−2^31, 2^31− 1]。
 * 请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class Reverse {

    //太笨了 自己 把int 干嘛要转换成 string 去解决
    public int reverse(int x){
        // int ---->  String  三种方法
//        String str = String.valueOf(x);
//        String str = x + "";
        String str;
        if (x>=0){
            str = Integer.toString(x);  //用包装类
        }else{
            str = Integer.toString(x).substring(1);
        }

        char[] arr = str.toCharArray();
        for (int i =0, y =arr.length-1; i<y; i++, y--){
            char temp;
            temp = arr[i];
            arr[i] = arr[y];
            arr[y] = temp;
        }

//        System.out.println(arr.toString());
        int parseInt = Integer.parseInt(String.copyValueOf(arr));
        if (parseInt > 214748364 || parseInt < -214748364){
            return 0;
        }
        if (x>=0){
            return parseInt;
        }else {
            return -parseInt;
        }
    }



    public int reverseCorrect(int x){

        int result = 0;
        while (x!=0){
            int temp = x%10;
            int newResult = result*10+temp;
            //如果数字溢出，直接返回0   如果溢出  直接判断原数 和现数是否相等
            if ((newResult-temp)/ 10 != result)
                return 0;
            result = newResult;
            x = x /10;
        }
        return result;
    }

    @Test
    public void test(){
        int x = -120;
        System.out.println(reverseCorrect(x));
    }
}
