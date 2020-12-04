package string;

import org.junit.Test;

import java.time.Instant;

/**
 * @author JeffCar
 * @date 11/30/2020 - 2:17 PM
 *
 * 将一个字符串进行反转，能够指定部分进行反转
 * 例： abcefg  变为  afecbg
 *
 *
 */
public class StringDemo {

    public static void main(String[] args) {
        String str = "abcdefg";
        String str2 = reverse(str,1,5);
        System.out.println(str2);
    }

    public static String reverse(String str, int startIndex, int endIndex){
        //方法一： 转换成char[]
//        char[]  arr = str.toCharArray();
//        for (int i= startIndex, j = endIndex; i < j; i++, j--){
//            char temp = arr[i];
//            arr[i] = arr[j];
//            arr[j] = temp;
//        }
//        String str1 = new String(arr);
//
//        return str1;

        //方法二：String拼接
        String reversestr = str.substring(0,startIndex);
        for (int i = endIndex; i>= startIndex; i--){
            reversestr += str.charAt(i);
        }
        reversestr += str.substring(endIndex+1);

        return reversestr;
    }


    public int appearTime(String str, String str1){
        int mainLength = str.length();
        int subLength = str1.length();
        int count = 0;
        int index = 0;
        if(mainLength >= subLength){
//            while ((index = str.indexOf(str1)) != -1){
//                count++;
//                str = str.substring(index+str1.length());
//            }
            while ((index = str.indexOf(str1,index))!= -1){
                count++;
                index = index + str1.length();
            }
            return count;
        }else {
            return 0;
        }

    }

    @Test
    public void test1(){
        String main = "abcdabcdabcd";
        String sub = "ab";
        int count = appearTime(main,sub);
        System.out.println(count);
    }

    /**
     * 获取最大相同子串 (只有一个)
     * 通过短的串 依次递减去 判断是否存在里面（contains）
     * str1 = "wonkcmlieowjrwnvwkllzlji"   str2 = "lieowjkllzji"
     * @param str1
     * @param str2
     * @return
     */

    public String getMaxSameString(String str1, String str2){
        String maxString = (str1.length()>str2.length())? str1:str2;
        String minString = (str1.length()<= str2.length())?str1:str2;

        for (int i =0; i< minString.length() ; i++){
            for (int x=0, y=minString.length()-i; y<=minString.length() ; x++, y++){
                String subStr = minString.substring(x,y);
                if (maxString.contains(subStr)){
                    return subStr;
                }
            }
        }
        return null;
    }

    @Test
    public void test2(){
        String str1 = "wonkcmlieowjrwnvwkllzlji";
        String str2 = "lieowjkllzji";
        String result = getMaxSameString(str1,str2);
        System.out.println(result);
    }

    @Test
    public void test3(){
        String str = null;
        StringBuffer  stringBuffer = new StringBuffer();

        stringBuffer.append(str);
        System.out.println(stringBuffer.length());
        System.out.println(stringBuffer);
    }
}
